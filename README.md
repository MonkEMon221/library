
## Bobble UI Library

Semi-customized libraries for Bobble ui application.


## Customization And Attributes

Libraries -:

1. BobbleButton

| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| app:buttonColor  | #03DAC5(Light) #636363(Dark) | @color/colorAccent | Color of Button |
| app:circle_radius  | 45dp  | 35dp | adjust radius of button |
| app:isDarkTheme  | false  | true | set theme for button |

2. BobbleImage
| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| app:backgroundColor  | #FFFFFF(Light) #636363(Dark) | @color/colorAccent | background color of ImageView |
| app:isDarkTheme  | false  | true | set theme for ImageView |

3. BobbleFab
| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| app:backgroundTint  | #ECEFF1(Light) #636363(Dark) | @color/colorAccent | Color of fab |
| app:maxImageSize | 40dp  | 35dp | set ImageSize of fab symbol |
| app:fabCustomSize  | 75dp  | 35dp | set size of fab |
| app:isDarkTheme  | false  | true | set theme for fab |

4. BobbleCardView
| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| app:cardBackgroundColor  | #FFFFFF(Light) #636363(Dark) | @color/colorAccent | background Color of CardView |
| app:cardCornerRadius  | 30dp  | 35dp | adjust radius of CardView |
| app:isDarkTheme  | false  | true | set theme for CardView |

5. BobbleRoundCornerEditText
| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| app:textBoxColor | #FFFFFF(Light) #636363(Dark) | @color/colorAccent | background Color of RoundCorner Edittext |
| app:corner_radius| 30dp  | 35dp | adjust radius of RoundCorner EditText |
| app:borderColor  | #000000(Light) #FFFFFF(Dark) | @color/colorAccent | border color of RoundCorner Edittext |
| app:borderWidth  | 3dp  | 5dp | set borderWidth for RoundCorner Edittext |
| app:isDarkTheme  | false  | true | set theme for RoundCorner Edittext |

6. BobbleImageButton
| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| app:buttonBackGround  | #FFFFFF(Light) #636363(Dark) | @color/colorAccent | background color of ImageView Button |
| app:isDarkTheme  | false  | true | set theme for ImageView Button |

7. BobbleImageEdittext
| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| app:text  |  | @string/Hello_World! | pre written text in the Edittext |
| app:editTextHint  |   | @string/Email | set hint for the edittext box |
| app:inputType  |  | email | set input type for the EditText |
| app:maxLength  |50 | 100 | set max inputlength for the EditText |
| app:rightIcon  |   | @drawable/image | set right icon in the edittext box |
| app:leftIcon  |   | @drawable/image | set left icon in the edittext box |
| app:isDarkTheme  | false  | true | set theme for BobbleImageEdittext |

8. BobbleTabLayout
| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| app:tabTextColor  | #9E9E9E | @color/colorAccent | set text color of Tabs |
| app:tabSelectedTextColor  | #000000(Light) #FFFFFF(Dark)  | @color/colorAccent | set text color of Selected tabs color |
| app:tabIndicatorColor  | #018786 | @color/colorAccent | set color of selected tab indicator |
| app:boldText  |false | true | set if tab text should be bold |
| app:selectedTabBoldText  |  false | true | set if selected tab text should be bold |
| app:isDarkTheme  | false  | true | set theme for BobbleTabLayout |







## Installation

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

dependencies {
	        implementation 'com.github.MonkEMon221:library:Tag'
	}

    
