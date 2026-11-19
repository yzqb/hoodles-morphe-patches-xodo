# Xodo Patches

用于 Morphe 的 Xodo 补丁，只保留 Xodo 及必要构建依赖。

- 应用包名：`com.xodo.pdf.reader`
- 推荐版本：**11.3.1**
- 补丁：Enable Pro，包含所需的签名检查处理。

## 添加补丁源

[点击添加到 Morphe](https://morphe.software/add-source?github=yzqb/xodo-patches)

也可在 Morphe 的“来源”中添加：

```text
https://github.com/yzqb/xodo-patches
```

[下载补丁包](https://github.com/yzqb/xodo-patches/releases/latest)。本仓库不发布 APK。

## 构建

安装 JDK 21 和 JDK 17，设置 GitHub Packages 所需的 `GITHUB_ACTOR`、`GITHUB_TOKEN`，运行：

```sh
./gradlew :patches:build
```

补丁包位于 `patches/build/libs/patches-1.0.0.mpp`。

## 来源与许可证

提取自 [lootdev78/morphe-patches-sc](https://github.com/lootdev78/morphe-patches-sc)，
上游提交为 `7dc2ce8db15876203e1b83cacd3a9916fd12b65e`。
Xodo 补丁原作者为 [Hoo-dles](https://github.com/hoo-dles/morphe-patches)。

本仓库独立维护。2026-11-19 的修改包括提取 Xodo、精简构建配置、将推荐版本改为 11.3.1，以及添加本仓库的发布元数据。

代码采用 [GPL-3.0](LICENSE)，保留原作者版权声明及 [NOTICE](NOTICE)。
