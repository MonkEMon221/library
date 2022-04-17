
## Bobble UI Library

Semi-customized libraries for Bobble ui application.


## Customization And Attributes

Libraries -:

1. BobbleButton

| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| app:backgroundTint  |Enabled :- #018786(Light) #E0E0E0(Dark) 
// On Pressed:-#636363(Light) #636363(Dark) 
// Disabled:-#E0E0E0(Light) #9E9E9E(Dark)  | @color/colorAccent | Color of Button |
| android:textColor  | Enabled:-#FFFFFF(Light) #636363(Dark) // On Pressed:-#FFFFFF(Light) #FFFFFF(Dark) // Disabled:-#636363(Light) #9E9E9E(Dark)  | @color/colorAccent | Color of Button Text |
| app:cornerRadius  | 30dp  | 35dp | adjust radius of button |
| app:customTheme  | "default"  | "dark"/"light" | set theme for button |

2. BobbleImage

| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| app:backgroundColor  |#E0F7FA(Light) #212121(Dark) | @color/colorAccent | background color of ImageView
| app:customTheme  | "default"  | "dark"/"light" | set theme for ImageView |

3. BobbleFab

| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| app:backgroundTint  | #FFFFFF(Light) #636363(Dark) | @color/colorAccent | Color of fab |
| app:maxImageSize | 40dp  | 35dp | set ImageSize of fab symbol |
| app:fabCustomSize  | 75dp  | 35dp | set size of fab |
| app:customTheme  | "default"  | "dark"/"light" | set theme for fab |

4. BobbleCardView

| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| app:cardBackgroundColor  | #E0F7FA(Light) #212121(Dark) | @color/colorAccent | background Color of CardView |
| app:cardCornerRadius  | 30dp  | 35dp | adjust radius of CardView |
| app:customTheme  | "default"  | "dark"/"light" | set theme for CardView |

5. BobbleRoundCornerEditText

| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| android:textColor | #9E9E9E(Light) #FFFFFF(Dark) | @color/colorAccent | text Color of RoundCorner Edittext |
| app:textBoxColor | #FFFFFF(Light) #636363(Dark) | @color/colorAccent | background Color of RoundCorner Edittext |
| app:corner_radius| 30dp  | 35dp | adjust radius of RoundCorner EditText |
| app:borderColor  | #000000(Light) #FFFFFF(Dark) | @color/colorAccent | border color of RoundCorner Edittext |
| app:borderWidth  | 3dp  | 5dp | set borderWidth for RoundCorner Edittext |
| app:customTheme  | "default"  | "dark"/"light" | set theme for RoundCorner Edittext |

6. BobbleImageButton

| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| app:buttonBackGround  |Enabled :- #018786(Light) #E0E0E0(Dark) // On Pressed:-#636363(Light) #636363(Dark) // Disabled:-#E0E0E0(Light) #9E9E9E(Dark) | @color/colorAccent | background color of ImageView Button |
| app:customTheme | "default"  | "dark"/"light" | set theme for ImageView Button |

7. BobbleTabLayout

| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| app:tabTextColor  | #9E9E9E(Light) #636363(Dark) | @color/colorAccent | set text color of Tabs |
| app:tabSelectedTextColor  | #000000(Light) #FFFFFF(Dark)  | @color/colorAccent | set text color of Selected tabs |
| app:tabIndicatorColor  | #03DAC5(Light) #018786(Dark) | @color/colorAccent | set color of selected tab indicator |
| app:boldText  |false | true | set if tab text should be bold |
| app:selectedTabBoldText  |  false | true | set if selected tab text should be bold |
| app:customTheme  | "default"  | "dark"/"light" | set theme for BobbleTabLayout |


## Installation

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency

```
dependencies {
	        implementation 'com.github.MonkEMon221:library:Tag'
	}
```
    
