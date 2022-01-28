package com.example.electronicpictureframes

import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.concurrent.timer
import kotlin.math.log

class PhotoFrameActivity: AppCompatActivity() {

    private val photoList = mutableListOf<Uri>()

    private var currentPosition = 0

    private val photoImageView: ImageView by lazy {
        findViewById(R.id.photoImageView)
    }
    private val backgroundPhotoImageView: ImageView by lazy{
        findViewById(R.id.backgroundPhotoImageView)
    }

    private var timer: Timer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_frame)
        Log.d("PhotoFrameActivity", "onCreate!!!")

        getPhotoUriFromIntent()
    }

    private fun getPhotoUriFromIntent() {
        val size = intent.getIntExtra("photoListSize", 0)
        for (i in 0..size) {
            //let null이 아닐 때에만 실행
            intent.getStringExtra("photo$i")?.let {
                photoList.add(Uri.parse(it))
            }
        }
    }

    private fun startTimer() {
        //5초에 한 번씩 이미지가 바뀐다.
        timer = timer(period = 5000) {
            runOnUiThread {
                Log.d("PhotoFrameActivity", "5초 지나감!!!")

                val current = currentPosition
                val next = (current+1) % photoList.size

                //View 애니메이션 구현 Fade In
                backgroundPhotoImageView.setImageURI(photoList[current])
                //alpha = 투명도, 투명도가 0이면 완전히 투명해져서 photoImageView가 보이지 않게 되고 backgoundPhotoImageView가 보인다.
                photoImageView.alpha = 0f
                //photoImageView에는 다음 이미지를 적용
                photoImageView.setImageURI(photoList[next])
                //애니메이션 alpha = 0f -> alpha = 1.0f로 1초동안 변화하여 서서히 photoImageView가 Fade In 된다.
                photoImageView.animate()
                    .alpha(1.0f)
                    .setDuration(1000)
                    .start()
                currentPosition = next
            }
        }
    }

    override fun onStop() {
        super.onStop()

        timer?.cancel()
        Log.d("PhotoFrameActivity", "onStop!!! timer cancel")
    }

    override fun onStart() {
        super.onStart()
        startTimer()
        Log.d("PhotoFrameActivity", "onStart!!! timer start")

    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
        Log.d("PhotoFrameActivity", "onDestroy!!! timer cancel")

    }
}