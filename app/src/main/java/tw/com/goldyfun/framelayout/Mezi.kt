package tw.com.goldyfun.framelayout

import android.content.Context
import android.view.View
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint

class MeziView(context: Context) : View(context) {
    //定义相关变量,依次是妹子显示位置的X,Y坐标
    var bitmapX: Float = 0.toFloat()
    var bitmapY: Float = 0.toFloat()

    init {
        //设置妹子的起始坐标
        bitmapX = 0f
        bitmapY = 200f
    }

    //for "Custom view overrides onTouchEvent but not performClick" warning
    override fun performClick(): Boolean {
        return super.performClick()
    }

    //重写View类的onDraw()方法
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //创建,并且实例化Paint的对象
        val paint = Paint()
        //根据图片生成位图对象
        val bitmap = BitmapFactory.decodeResource(this.resources, R.drawable.s_jump)
        //绘制萌妹子
        canvas.drawBitmap(bitmap, bitmapX, bitmapY, paint)
        //判断图片是否回收,木有回收的话强制收回图片
        if (bitmap.isRecycled) {
            bitmap.recycle()
        }
    }
}