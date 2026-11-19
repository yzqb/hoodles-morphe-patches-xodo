import app.morphe.patcher.patch.Patch;
import app.morphe.patcher.patch.PatchLoader;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.jar.JarFile;

public final class VerifyBundle {
    private static void require(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    public static void main(String[] args) throws Exception {
        File bundle = new File(args[0]);
        try (JarFile jar = new JarFile(bundle)) {
            require(jar.getJarEntry("classes.dex") != null, "Android DEX is missing");
            require(jar.stream().noneMatch(entry -> !entry.isDirectory() && entry.getName().startsWith("hoodles/morphe/patches/")
                && !entry.getName().startsWith("hoodles/morphe/patches/xodo/")), "Non-Xodo app code found");
            require(jar.getJarEntry("LICENSE") != null, "GPL license is missing");
            require(jar.getJarEntry("NOTICE") != null, "Upstream NOTICE is missing");
            byte[] dex = jar.getInputStream(jar.getJarEntry("classes.dex")).readAllBytes();
            require(new String(dex, java.nio.charset.StandardCharsets.ISO_8859_1).contains("11.3.1"),
                "Recommended version is missing from Android DEX");
            var manifest = jar.getManifest().getMainAttributes();
            require("Xodo Patches".equals(manifest.getValue("Name")), "Wrong bundle name");
            require("1.0.0".equals(manifest.getValue("Version")), "Wrong bundle version");
            require("https://github.com/yzqb/hoodles-morphe-patches-xodo".equals(manifest.getValue("Source")),
                "Wrong source repository");
        }
        Set<Patch<?>> patches = new PatchLoader.Jar(Set.of(bundle));
        require(patches.size() == 1, "Expected only Enable Pro, loaded: " + patches);
        Patch<?> patch = patches.iterator().next();
        require("Enable Pro".equals(patch.getName()), "Wrong patch name");
        require(patch.getCompatibility().size() == 1, "Expected one app");
        var compatibility = patch.getCompatibility().get(0);
        require("com.xodo.pdf.reader".equals(compatibility.getPackageName()), "Wrong app package");
        require(compatibility.getTargets().stream().map(target -> target.getVersion()).toList()
            .equals(List.of("11.3.1")), "Wrong recommended version");
        require(patch.getDependencies().size() == 1, "Signature-check dependency is missing");
        require(patch.getDependencies().iterator().next().getName() == null,
            "Signature-check helper must remain an internal dependency");
        System.out.println("Verified bundle: Enable Pro; com.xodo.pdf.reader; target 11.3.1; signature dependency; Android DEX");
    }
}
