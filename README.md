
# Bobble UI Library

Semi-customized libraries for Bobble ui application.


# Customization And Attributes

Libraries -:

1. BobbleButton

| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| app:backgroundTint  |Enabled :- #018786(Light) #E0E0E0(Dark) <br />  <br /> On Pressed :- #636363(Light) #636363(Dark) <br />  <br />  Disabled :- #E0E0E0(Light) #9E9E9E(Dark)  | @color/colorAccent | Color of Button |
| android:textColor  | Enabled :- #FFFFFF(Light) #636363(Dark) <br /> <br />  On Pressed :- #FFFFFF(Light) #FFFFFF(Dark) <br /> <br />  Disabled :- #636363(Light) #9E9E9E(Dark)  | @color/colorAccent | Color of Button Text |
| app:cornerRadius  | 30dp  | 35dp | adjust radius of button |
| app:customTheme  | "default"  | "dark"/"light" | set theme for button |

2. BobbleImage

| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| app:backgroundColor  |#E0F7FA(Light) #212121(Dark) | @color/colorAccent | background color of ImageView
| app:imageColor1  |#000000(Light) #03DAC5(Dark) | @color/colorAccent |set Color of first image in imageView
| app:imageColor2  |#000000(Light) #03DAC5(Dark) | @color/colorAccent |set Color of second image in imageView
| app:src1  | | @drawable/your_image |set image resource of first image in imageView
| app:src2  | | @drawable/your_image |set image resource of second image in imageView
| app:gravityImage1  |"top"| "center" |set image gravity of first image in imageView
| app:gravityImage2  |"top"| "center" |set image gravity of second image in imageView
| app:translationZImage1  | "0dp" | "2dp" |set elevation to top for first image in imageView
| app:translationZImage2  | "0dp" | "2dp" |set elevation to top for second image in imageView
| app:marginImage1  | "0dp" | "8dp" |set margin of first image in imageView
| app:marginImage2  | "0dp" | "8dp" |set margin of second image in imageView
| app:enableColorFilter1  | true | false |enable/disable filling color for image 1 
| app:enableColorFilter2  | true | false |enable/disable filling color for image 2 
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

5. BobbleEditText

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
| app:buttonBackGround  |Enabled :- #018786(Light) #E0E0E0(Dark) <br /> <br />  On Pressed :- #636363(Light) #636363(Dark) <br /> <br />  Disabled :- #E0E0E0(Light) #9E9E9E(Dark) | @color/colorAccent | background color of ImageView Button |
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


# Initializing Programatically


Button
```bash
        binding.button.buttonCornerRadius(22f)   //Change Button Radius
        binding.button.backgroundColor(ColorStateList.valueOf(Color.CYAN))   //Change Button Color
        binding.button.buttonTextColor(ColorStateList.valueOf(Color.BLACK))  //Change Button Text Color
        binding.button.setTheme("dark")     //Set Dark Theme
        binding.button.setEnable(false)   //Disable Button
```
ImageView
```bash
        binding.image.setBackgroundColor(Color.parseColor("#FFA726"))   //Change Image Background
	binding.image.setColorImage1(R.color.gray,PorterDuff.Mode.SRC_ATOP)    //Change Color of first image
	binding.image.setColorImage2(R.color.gray,PorterDuff.Mode.SRC_ATOP)    //Change Color of second image
	binding.image.setImage1Drawable(ContextCompat.getDrawable(context, R.drawable.your_image))   //set first image resource
	binding.image.setImage2Drawable(ContextCompat.getDrawable(context, R.drawable.your_image))   //set second image resource
	binding.image.setGravityImage1("center")   //set gravity of first image 
	binding.image.setGravityImage2("center")   //set gravity of second image
	binding.image.settranslationZImage1(2f)    //set elevation to top for first image in imageView
	binding.image.settranslationZImage2(2f)    //set elevation to top for second image in imageView
	binding.enableColorFilter1(false)   //enable/disable filling color for image 1 
	binding.enableColorFilter2(false)   //enable/disable filling color for image 2 
        binding.image.setTheme("dark")   //Set Dark Theme
```
Floating Action Button
```bash
        binding.fab.backgroundTintList = ColorStateList.valueOf(Color.BLUE) //Create border Color
        binding.fab.setTheme("dark")    //Set Dark Theme
        binding.fab.maxImageSize(40f)   //Set Fab icon Size
        binding.fab.fabCustomSize(90f)  //Set Fab Size
```
CardView
```bash
        binding.card.cardBackGroundColor(Color.parseColor("#FFA726"))   //Set Card Background Color
        binding.card.cardCornerRadius(0f)   //Set Card Corner Radius
        binding.card.setTheme("dark")   //Set Dark Theme
```
EditText
```bash
        binding.edit.setRadius(0f)   //set EditText box radius
        binding.edit.setBorderWidth(2f)  //set box width
        binding.edit.borderColor(Color.parseColor("#E05021"))   //set edit box border color
        binding.edit.textBoxColor(Color.parseColor("#FFA726"))  //set edit box color
        binding.edit.setTheme("dark")   //Set Dark Theme
```
ImageButton
```bash
        binding.imgButton.backgroundColor(ColorStateList.valueOf(Color.BLUE))  //set image button background color
        binding.imgButton.setTheme("dark")   //Set Dark Theme
        binding.imgButton.setEnable(false)  //Disable image button
```
TabLayout  
```bash
         TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.setIcon(R.drawable.ic_search)   //set tab icon
                }
                1 -> {
                    tab.text = "TAB"  //set tab text
                }
            }
            binding.tabLayout.setTextColor(Color.parseColor("#FFA726"))   //set tab text color
            binding.tabLayout.setSelectedTabTextColor(Color.parseColor("#FFA726"))   //set selected tab text color
            binding.tabLayout.setIndicatorColor(Color.parseColor("#FFA726"))   //set tab indicator color
            binding.tabLayout.setTabTextBold(true)   //set tab text as bold
            binding.tabLayout.setSelectedTabTextBold(true)    //set selected tab text as bold
            binding.tabLayout.setTheme("dark")   //Set Dark Theme
        }.attach()
```


# Installation

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
    
