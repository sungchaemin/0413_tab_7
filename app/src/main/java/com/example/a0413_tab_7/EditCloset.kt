package com.example.myapplication

import android.Manifest
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.ImageDecoder
import android.icu.text.SimpleDateFormat
import android.net.Uri
import android.opengl.Visibility
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.LayoutInflaterFactory
import com.example.a0413_tab_7.BaseActivity
import com.example.a0413_tab_7.R
import com.example.a0413_tab_7.databinding.ActivityEditClosetBinding



class EditCloset : BaseActivity() {

    lateinit var pic_plus: ImageView
    lateinit var back: ImageView

    lateinit var outer: Button
    lateinit var top: Button
    lateinit var bottom: Button
    lateinit var onepiece: Button
    lateinit var shoes: Button

    lateinit var outer_txtview: TextView
    lateinit var outer_layout: LinearLayout
    lateinit var top_txtview: TextView
    lateinit var top_layout: LinearLayout
    lateinit var bottom_txtview1: TextView
    lateinit var bottom_layout1: LinearLayout
    lateinit var bottom_txtview2: TextView
    lateinit var bottom_layout2: LinearLayout
    lateinit var onepiece_txtview1: TextView
    lateinit var onepiece_layout1: LinearLayout
    lateinit var onepiece_txtview2: TextView
    lateinit var onepiece_layout2: LinearLayout
    lateinit var shoes_txtview: TextView
    lateinit var shoes_layout: LinearLayout

    val PERM_STORAGE = 9
    val PERM_CAMERA = 10
    val REQ_CAMERA = 11
    val REQ_GALLERY =12

    val binding by lazy { ActivityEditClosetBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_closet)

        setContentView(binding.root)
        pic_plus = findViewById<ImageView>(R.id.pic_plus)
        back = findViewById(R.id.back)

        outer = findViewById<Button>(R.id.outer)
        top = findViewById<Button>(R.id.top)
        bottom = findViewById<Button>(R.id.bottom)
        onepiece = findViewById<Button>(R.id.onepiece)
        shoes = findViewById<Button>(R.id.shoes)

        outer_txtview = findViewById(R.id.type_detail_outer_txtview)
        top_txtview = findViewById(R.id.type_detail_top_txtview)
        bottom_txtview1 = findViewById(R.id.type_detail_bottom_txtview1)
        bottom_txtview2 = findViewById(R.id.type_detail_bottom_txtview2)
        onepiece_txtview1 = findViewById(R.id.type_detail_onepiece_txtview1)
        onepiece_txtview2 = findViewById(R.id.type_detail_onepiece_txtview2)
        shoes_txtview = findViewById(R.id.type_detail_shoes_txtview)

        outer_layout = findViewById(R.id.type_detail_outer_layout)
        top_layout = findViewById(R.id.type_detail_top_layout)
        bottom_layout1 = findViewById(R.id.type_detail_bottom_layout1)
        bottom_layout2 = findViewById(R.id.type_detail_bottom_layout2)
        onepiece_layout1 = findViewById(R.id.type_detail_onepiece_layout1)
        onepiece_layout2 = findViewById(R.id.type_detail_onepiece_layout2)
        shoes_layout = findViewById(R.id.type_detail_shoes_layout)

        clickBtn(outer, outer_txtview, outer_layout)
        clickBtn(top, top_txtview, top_layout)
        clickBtn(bottom, bottom_txtview1, bottom_txtview2, bottom_layout1, bottom_layout2)
        clickBtn(onepiece, onepiece_txtview1, onepiece_txtview2, onepiece_layout1, onepiece_layout2)
        clickBtn(shoes, shoes_txtview, shoes_layout)


        back.setOnClickListener {
            finish()
        }


        // 1. 공용저장소 권한이 있는지 확인
        requirePermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), PERM_STORAGE)
    }

    fun clickBtn(btn:Button, txtview:TextView, layout: LinearLayout) {
        btn.setOnClickListener {
            if (txtview.visibility == VISIBLE) {
                backgroundClear()
                visibleGone()
            } else {
                backgroundClear()
                visibleGone()
                txtview.visibility = VISIBLE
                layout.visibility = VISIBLE
                btn.setBackgroundColor(Color.parseColor("#BFCBE5"))
                btn.setBackgroundResource(R.drawable.button_roud2)
            }
        }
    }
    fun clickBtn(btn:Button, txtview:TextView, txtview2: TextView, layout: LinearLayout, layout2: LinearLayout) {
        btn.setOnClickListener {
            if (txtview.visibility == VISIBLE) {
                backgroundClear()
                visibleGone()
            } else {
                backgroundClear()
                visibleGone()
                txtview.visibility = VISIBLE
                layout.visibility = VISIBLE
                txtview2.visibility = VISIBLE
                layout2.visibility = VISIBLE
                btn.setBackgroundColor(Color.parseColor("#BFCBE5"))
                btn.setBackgroundResource(R.drawable.button_roud2)
            }
        }
    }
    fun visibleGone() {
        outer_txtview.visibility = View.GONE
        outer_layout.visibility = View.GONE
        top_txtview.visibility = View.GONE
        top_layout.visibility = View.GONE
        bottom_txtview1.visibility = View.GONE
        bottom_txtview2.visibility = View.GONE
        bottom_layout1.visibility = View.GONE
        bottom_layout2.visibility = View.GONE
        onepiece_txtview1.visibility = View.GONE
        onepiece_txtview2.visibility = View.GONE
        onepiece_layout1.visibility = View.GONE
        onepiece_layout2.visibility = View.GONE
        shoes_txtview.visibility = View.GONE
        shoes_layout.visibility = View.GONE
    }

    fun backgroundClear() {
        outer.setBackgroundResource(R.drawable.button_roud)
        top.setBackgroundResource(R.drawable.button_roud)
        bottom.setBackgroundResource(R.drawable.button_roud)
        onepiece.setBackgroundResource(R.drawable.button_roud)
        shoes.setBackgroundResource(R.drawable.button_roud)
    }

    fun initViews() {
        binding.picPlus.setOnClickListener {
            openGallery()
        }
    }

    fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, REQ_CAMERA)
    }

    fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = MediaStore.Images.Media.CONTENT_TYPE
        startActivityForResult(intent, REQ_GALLERY)
    }

    fun createImageUri(filename:String, mimeType:String) : Uri? {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.DISPLAY_NAME, filename)
        values.put(MediaStore.Images.Media.MIME_TYPE, mimeType)

        return contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
    }

    fun newFileName() : String {
        val sdf = SimpleDateFormat("yyyyMMdd_HHmmss")
        val filename = sdf.format(System.currentTimeMillis())
        return "${filename}.jpg"
    }

    // 원본 이미지 불러오는 메서드
    fun loadBitmap(photoUri: Uri) : Bitmap? {
        try {
            return if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O_MR1) {
                val source  = ImageDecoder.createSource(contentResolver, photoUri)
                ImageDecoder.decodeBitmap(source)
            } else {
                MediaStore.Images.Media.getBitmap(contentResolver, photoUri)

            }
        } catch (e:Exception) {
            e.printStackTrace()
        }
        return null
    }


    override fun permissionGranted(requestCode: Int) {
        when(requestCode) {
            PERM_STORAGE -> initViews()
            PERM_CAMERA -> openCamera()
        }
    }

    override fun permissionDenied(requestCode: Int) {
        when(requestCode) {
            PERM_STORAGE -> {
                Toast.makeText(this, "공용 저장소 권한을 승인해야 앱을 사용할 수 있습니다.", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    var realUri = null

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                REQ_CAMERA -> {
                    val bitmap = data?.extras?.get("data") as Bitmap
                    binding.picPlus.setImageBitmap(bitmap)
                    realUri?.let { uri ->
                        val bitmap = loadBitmap(uri)
                        binding.picPlus.setImageBitmap(bitmap)

                        realUri = null

                    }
                }
                REQ_GALLERY -> {
                    data?.data?.let {uri ->
                        binding.picPlus.setImageURI(uri)
                    }
                }
            }
        }
    }


}