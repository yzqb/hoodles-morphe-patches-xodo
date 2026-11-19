# Xodo Patches

用于 Morphe 的 Xodo 补丁，只保留 Xodo 及必要构建依赖。

- 应用包名：`com.xodo.pdf.reader`
- 推荐版本：**11.3.1**
- 补丁：Enable Pro，包含所需的签名检查处理。

## 添加补丁源

[点击添加到 Morphe](https://morphe.software/add-source?github=yzqb/hoodles-morphe-patches-xodo)

也可在 Morphe 的“来源”中添加：

```text
https://github.com/yzqb/hoodles-morphe-patches-xodo
```

[下载补丁包](https://github.com/yzqb/hoodles-morphe-patches-xodo/releases/latest)。本仓库不发布 APK。

## 构建

安装 JDK 21 和 JDK 17，设置 GitHub Packages 所需的 `GITHUB_ACTOR`、`GITHUB_TOKEN`，运行：

```sh
./gradlew :patches:build
```

补丁包位于 `patches/build/libs/patches-1.0.0.mpp`。

## 来源与许可证

原作者为 Hoo-dles。原始项目是 [hoo-dles/morphe-patches](https://github.com/hoo-dles/morphe-patches)，该仓库目前已被 GitHub 禁用。

本仓库实际从 [lootdev78/morphe-patches-sc](https://github.com/lootdev78/morphe-patches-sc) 提取 Xodo 代码，
引用提交为 `7dc2ce8db15876203e1b83cacd3a9916fd12b65e`。

本仓库独立维护。2026-11-19 的修改包括提取 Xodo、精简构建配置、将推荐版本改为 11.3.1，以及配置独立补丁源。

代码采用 [GPL-3.0](LICENSE)，保留原作者版权声明及 [NOTICE](NOTICE)。
