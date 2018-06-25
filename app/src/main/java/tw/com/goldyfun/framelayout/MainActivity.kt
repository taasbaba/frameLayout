package tw.com.goldyfun.framelayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_main.*
import android.view.MotionEvent
import android.view.View
import android.widget.RelativeLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var frame: FrameLayout = mylayout
        val mezi: MeziView = MeziView(this@MainActivity)
        mezi.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View, m: MotionEvent): Boolean {
                mezi.performClick()
                //设置妹子显示的位置
                mezi.bitmapX = m.x - 150
                mezi.bitmapY = m.y - 150
                //调用重绘方法
                mezi.invalidate()
                return true
            }
        })
        frame.addView(mezi)
        configureVideoView()
    }

    private fun configureVideoView() {

        videoView1.setVideoPath(
                "http://devimages.apple.com/iphone/samples/bipbop/gear1/prog_index.m3u8")
        val layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT)
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP)
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT)
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
        //mylayout.setLayoutParams(layoutParams)
        videoView1.start()
    }
}
