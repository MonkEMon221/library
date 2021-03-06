
# Bobble UI Library

Semi-customized libraries for Bobble ui application.


# Customization And Attributes

Libraries -:

1. BobbleButton

| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| app:backgroundTint  |Enabled :- #018786(Light) #E0E0E0(Dark) <br />  <br /> On Pressed :- #636363(Light) #636363(Dark) <br />  <br />  Disabled :- #E0E0E0(Light) #9E9E9E(Dark)  | @color/colorAccent | Color of Button |
| android:textColor  | Enabled :- #FFFFFF(Light) #636363(Dark) <br /> <br />  On Pressed :- #FFFFFF(Light) #FFFFFF(Dark) <br /> <br />  Disabled :- #636363(Light) #9E9E9E(Dark)  | @color/colorAccent | Color of Button Text |
| app:cornerRadius  | 30sdp  | 35dp | adjust radius of button |
| app:customTheme  | "default"  | "dark"/"light" | set theme for button |

2. BobbleImage

| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| app:backgroundColor  |#E0F7FA(Light) #212121(Dark) | @color/colorAccent | background color of ImageView
| app:imageColorPrimary  |#000000(Light) #03DAC5(Dark) | @color/colorAccent |set Color of first image in imageView
| app:imageColorSecondary  |#000000(Light) #03DAC5(Dark) | @color/colorAccent |set Color of second image in imageView
| app:srcPrimary  | | @drawable/your_image |set image resource of first image in imageView
| app:srcSecondary  | | @drawable/your_image |set image resource of second image in imageView
| app:gravityImagePrimary  |"top"| "center" |set image gravity of first image in imageView
| app:gravityImageSecondary  |"top"| "center" |set image gravity of second image in imageView
| app:scaleTypePrimary  |"fitCenter"| "center" |set image scaleType of first image in imageView
| app:scaleTypeSecondary  |"firCenter"| "center" |set image scaleType of second image in imageView
| app:translationZImagePrimary  | "0sdp" | "2dp" |set elevation to top for first image in imageView
| app:translationZImageSecondary  | "0sdp" | "2dp" |set elevation to top for second image in imageView
| app:marginImagePrimary  | "0sdp" | "8dp" |set margin of first image in imageView
| app:marginImageSecondary  | "0sdp" | "8dp" |set margin of second image in imageView
| app:enableColorFilterPrimary  | true | false |enable/disable filling color for image 1 
| app:enableColorFilterSecondary  | true | false |enable/disable filling color for image 2 
| app:customTheme  | "default"  | "dark"/"light" | set theme for ImageView |

3. BobbleFab

| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| app:backgroundTint  | #FFFFFF(Light) #636363(Dark) | @color/colorAccent | Color of fab |
| app:maxImageSize | 40sdp  | 35dp | set ImageSize of fab symbol |
| app:fabCustomSize  | 75sdp  | 35dp | set size of fab |
| app:customTheme  | "default"  | "dark"/"light" | set theme for fab |

4. BobbleCardView

| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| app:cardBackgroundColor  | #E0F7FA(Light) #212121(Dark) | @color/colorAccent | background Color of CardView |
| app:cardCornerRadius  | 30sdp  | 35dp | adjust radius of CardView |
| app:customTheme  | "default"  | "dark"/"light" | set theme for CardView |

5. BobbleEditText

| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| android:textColor | #9E9E9E(Light) #FFFFFF(Dark) | @color/colorAccent | text Color of RoundCorner Edittext |
| app:textBoxColor | #FFFFFF(Light) #636363(Dark) | @color/colorAccent | background Color of RoundCorner Edittext |
| app:corner_radius| 30sdp  | 35dp | adjust radius of RoundCorner EditText |
| app:borderColor  | #000000(Light) #FFFFFF(Dark) | @color/colorAccent | border color of RoundCorner Edittext |
| app:borderWidth  | 1sdp  | 5dp | set borderWidth for RoundCorner Edittext |
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
| app:indicatorHeight  |  5sdp | 10dp | set indicator height |
| app:tabIndicatorRadius  |  15sdp | 10dp | set indicator radius |
| app:tabIndicatorMargin  |  25sdp | 10dp | set indicator margins |
| app:customTheme  | "default"  | "dark"/"light" | set theme for BobbleTabLayout |

8. BobbleCircleImageView

| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| app:backgroundColor  | #00FFFFFF | @color/colorAccent | background Color of CircleImage |
| app:borderColor  | #000000  | @color/colorAccent | set border Color of Circle Image |
| app:borderWidth  | 0  | 5dp | set border width |

9. BobbleTextView

| Attribute Name  | Default Value | Example Value | Description |
| ------------- | ------------- | ------------ | ------------- |
| app:minTextSize  | 8sdp |12sp| set min Text Size |
| app:maxTextSize  | text.textsize  |22sp| set max Text Size |


# Initializing Programatically


## Button
```bash
        binding.button.buttonCornerRadius(22f)   //Change Button Radius
        binding.button.backgroundColor(ColorStateList.valueOf(Color.CYAN))   //Change Button Color
        binding.button.buttonTextColor(ColorStateList.valueOf(Color.BLACK))  //Change Button Text Color
        binding.button.setTheme("dark")     //Set Theme
        binding.button.setEnable(false)   //Enable/Disable Button
```
## ImageView
```bash
        binding.image.setBackgroundColor(Color.parseColor("#FFA726"))   //Change Image Background
	binding.image.setColorImagePrimary(R.color.gray,PorterDuff.Mode.SRC_ATOP)    //Change Color of first image
	binding.image.setColorImageSecondary(R.color.gray,PorterDuff.Mode.SRC_ATOP)    //Change Color of second image
	binding.image.setDrawableImagePrimary(ContextCompat.getDrawable(context, R.drawable.your_image))   //set first image resource
	binding.image.setDrawableImageSecondary(ContextCompat.getDrawable(context, R.drawable.your_image))   //set second image resource
	binding.image.setGravityImagePrimary("center")   //set gravity of first image 
	binding.image.setGravityImageSecondary("center")   //set gravity of second image
	binding.image.setScaleTypeImagePrimary("center")   //set scaleType of first image 
	binding.image.setScaleTypeImageSecondary("center")   //set scaleType of second image
	binding.image.settranslationZImagePrimary(2f)    //set elevation to top for first image in imageView
	binding.image.settranslationZImageSecondary(2f)    //set elevation to top for second image in imageView
	binding.enableColorFilterPrimary(false)   //enable/disable filling color for image 1 
	binding.enableColorFilterSecondary(false)   //enable/disable filling color for image 2
	binding.setPrimaryImageWithGlide(context,imagePath,placeholder,error_image)   //set image 1 with glide
	binding.setSecondaryImageWithGlide(context,imagePath,placeholder,error_image)   //set image 2 with glide
        binding.image.setTheme("dark")   //Set Theme
```
## Floating Action Button
```bash
        binding.fab.backgroundTintList = ColorStateList.valueOf(Color.BLUE) //Create border Color
        binding.fab.setTheme("dark")    //Set Theme
        binding.fab.maxImageSize(40f)   //Set Fab icon Size
        binding.fab.fabCustomSize(90f)  //Set Fab Size
```
## CardView
```bash
        binding.card.cardBackGroundColor(Color.parseColor("#FFA726"))   //Set Card Background Color
        binding.card.cardCornerRadius(0f)   //Set Card Corner Radius
        binding.card.setTheme("dark")   //Set Theme
```
## EditText
```bash
        binding.edit.setRadius(0f)   //set EditText box radius
        binding.edit.setBorderWidth(2f)  //set box width
        binding.edit.setBorderColor(Color.parseColor("#E05021"))   //set edit box border color
        binding.edit.setTextBoxColor(Color.parseColor("#FFA726"))  //set edit box color
        binding.edit.setTheme("dark")   //Set Theme
```
## ImageButton
```bash
        binding.imgButton.backgroundColor(ColorStateList.valueOf(Color.BLUE))  //set image button background color
        binding.imgButton.setTheme("dark")   //Set Theme
        binding.imgButton.setEnable(false)  //Enable/Disable image button
```
## TabLayout  
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
	    binding.tabLayout.indicatorHeight(10f)    //set indicator height
	    binding.tabLayout.tabIndicatorRadius(10f)   //set indicator radius
	    binding.tabLayout.tabIndicatorMargin(10f)  //set indicator margin
            binding.tabLayout.setTheme("dark")   //Set Theme
        }.attach()
```

## CircleImageView
```bash
        binding.img.setCircleBackgroundColor("#000000")  //set image background color
        binding.img.setBorderColor("#000000")   //Set border color
        binding.img.setBorderWidth(5f)  //set border width
```

## TextView
```bash
        binding.txt.setMinTextSize(15f)  //set min text size
        binding.txt.setMaxTextSize(25f)   //Set max Text Size
```

# Creating Components Programatically

## Button
```bash
        val btn = BobbleUILibrary(this)
        btn.bobbleButton.setText("New Button")    //Set Button Text
        btn.bobbleButton.buttonCornerRadius(0f)    //Set Button Radius
        btn.bobbleButton.backgroundColor(ColorStateList.valueOf(Color.your_color))   ////Set Button Color
        btn.bobbleButton.buttonTextColor(ColorStateList.valueOf(Color.your_color))   //Set Button TextColor
        btn.bobbleButton.setEnable(false)    // Enable/Disable Button
        btn.bobbleButton.setTheme("default")    //Set Theme
```

## ImageView
```bash
        val img = BobbleUILibrary(this)
	img.bobbleImageView.backgroundColor(Color.parseColor("#3ffaaa"))    //Set image background color
        img.bobbleImageView.setDrawableImagePrimary(ContextCompat.getDrawable(this, R.drawable.your_image))    //Set first Image Resource
        img.bobbleImageView.setDrawableImageSecondary(ContextCompat.getDrawable(this, R.drawable.your_image))    //set second Image Resource
        img.bobbleImageView.setColorImagePrimary(R.color.your_color, PorterDuff.Mode.SRC_ATOP)    //Set first image color
        img.bobbleImageView.setColorImageSecondary(R.color.your_color,PorterDuff.Mode.SRC_ATOP)     //Set second image color
        img.bobbleImageView.setGravityImageSecondary("center")     //set second image gravity
        img.bobbleImageView.setGravityImagePrimary("center")     //set first image gravity
	img.bobbleImageView.setScaleTypeImagePrimary("center")   //set scaleType of first image 
	img.bobbleImageView.setScaleTypeImageSecondary("center")   //set scaleType of second image
        img.bobbleImageView.setTranslationZSecondary(4f)      //set elevation to top for second image in imageView
        img.bobbleImageView.setTranslationZImagePrimary(3f)      //set elevation to top for first image in imageView
        img.bobbleImageView.enableColorFilterPrimary(true)      //enable/disable filling color for image 1  
        img.bobbleImageView.enableColorFilterSecondary(true)     //enable/disable filling color for image 2 
        img.bobbleImageView.setTheme("default")    //Set theme
```

## Floating Action Button
```bash
        val fab = BobbleUILibrary(this)
        fab.bobbleFab.maxImageSize(100f)    //Set Fab icon Size
        fab.bobbleFab.fabCustomSize(200f)   //Set Fab size
        fab.bobbleFab.backgroundTintList = ColorStateList.valueOf(Color.your_color)    //Create border Color
        fab.bobbleFab.setTheme("default")    //Set theme
```

## CardView
```bash
        val card = BobbleUILibrary(this)
        card.bobbleCardView.cardCornerRadius(0f)    //Set Card corner radius
        card.bobbleCardView.cardBackGroundColor(Color.parseColor("#6200EE"))    //Set Card Background Color
        card.bobbleCardView.setTheme("default")    //set theme
```

## EditText
```bash
        val edtxt = BobbleUILibrary(this)
        edtxt.bobbleEditText.setRadius(0f)   //set EditText box radius
        edtxt.bobbleEditText.setBorderWidth(1f)   //set edittext box width
        edtxt.bobbleEditText.setTextColor(Color.your_color)   //set text color
        edtxt.bobbleEditText.borderColor(Color.parseColor("#E05021"))   //set border vcolor
        edtxt.bobbleEditText.textBoxColor(Color.parseColor("#6200EE"))  //set textbox color
        edtxt.bobbleEditText.setTheme("default")   /set theme
```

## ImageButton
```bash
        val imgBtn = BobbleUILibrary(this)
        imgBtn.bobbleImageButton.backgroundColor(ColorStateList.valueOf(Color.your_color))   //set image button background color
        imgBtn.bobbleImageButton.setEnable(true)   //Enable/Disable button
        imgBtn.bobbleImageButton.setTheme("default")   //Set theme
```

## TabLayout
```bash
        val tab = BobbleUILibrary(this)
        tab.bobbleTabLayout.setTextColor(Color.parseColor("#FFA726"))   // set tab text color
        tab.bobbleTabLayout.setSelectedTabTextColor(Color.parseColor("#FFA726"))    // set selected tab text color
        tab.bobbleTabLayout.setIndicatorColor(Color.parseColor("#def56a"))    //Set tab indicator color
        tab.bobbleTabLayout.setTabTextBold(true)   //Set tab text as bold
        tab.bobbleTabLayout.setSelectedTabTextBold(true)   //set selected tab text as bold
	tab.bobbleTabLayout.indicatorHeight(10f)    //set indicator height
	tab.bobbleTabLayout.tabIndicatorRadius(10f)   //set indicator radius
	tab.bobbleTabLayout.tabIndicatorMargin(10f)  //set indicator margin
        tab.bobbleTabLayout.setTheme("default")   //Set theme
```

## CircleImageView
```bash
        val img = BobbleUILibrary(this)
        img.bobbleCircleImageView.setCircleBackgroundColor("#000000")  //set image background color
        img.bobbleCircleImageView.setBorderColor("#000000")   //Set border color
        img.bobbleCircleImageView.setBorderWidth(5f)  //set border width
```

## TextView
```bash
        val txt = BobbleUILibrary(this)
        txt.bobbleTextView.setMinTextSize(15f)  //set min text size
        txt.bobbleTextView.setMaxTextSize(25f)   //Set max Text Size
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
    
