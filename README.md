# Xodo Patches

Xodo-only patches for Morphe, with the required build dependencies.

- Package: `com.xodo.pdf.reader`
- Recommended version: **11.3.1**
- Patch: Enable Pro, with its required signature-check dependency.

## Add the patch source

[Add to Morphe](https://morphe.software/add-source?github=yzqb/hoodles-morphe-patches-xodo)

Or add this repository URL under **Sources** in Morphe:

```text
https://github.com/yzqb/hoodles-morphe-patches-xodo
```

[Download the patch bundle](https://github.com/yzqb/hoodles-morphe-patches-xodo/releases/latest). This repository does not distribute APKs.

## Build

Install JDK 21 and JDK 17. Set `GITHUB_ACTOR` and `GITHUB_TOKEN` for GitHub Packages authentication, then run:

```sh
./gradlew :patches:build :patches:verifyBundle
```

The bundle is written to `patches/build/libs/patches-1.0.0.mpp`.

## Sources and license

The original author is Hoo-dles. The original project is [hoo-dles/morphe-patches](https://github.com/hoo-dles/morphe-patches), which GitHub has disabled.

The Xodo code in this repository was extracted from [lootdev78/morphe-patches-sc](https://github.com/lootdev78/morphe-patches-sc) at commit `7dc2ce8db15876203e1b83cacd3a9916fd12b65e`.

The code is licensed under [GPL-3.0](LICENSE). Original copyright notices and the upstream [NOTICE](NOTICE) are preserved.
