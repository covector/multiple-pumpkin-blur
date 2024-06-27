# Multiple Pumpkin Blur
Multiple pumpkin overlays controlled by NBT tag.

## Usage
1. Name the alternative textures as `pumpkinblur1.png`, `pumpkinblur2.png`, `pumpkinblur3.png`..., and put them inside the same resource pack folder `assets/minecraft/textures/misc` as the original `pumpkinblur.png`.
2. Wearing a pumpkin with the NBT tag `AltBlur` will display other overlays (e.g. `AltBlur: 2` will use `pumpkinblur2.png`).
```
/give @s minecraft:carved_pumpkin{AltBlur:2}
```