package com.demo_apps.myapplication
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.view.MotionEvent
import android.view.View
import kotlin.random.Random

class GameView(context: Context) : View(context) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var ballX = 0f
    private var ballY = 0f
    private var ballRadius = dp(14f)
    private var ballSpeed = dp(220f)

    private var basketX = 0f
    private var basketWidth = dp(100f)
    private var basketHeight = dp(20f)
    private var basketBottomMargin = dp(35f)

    private var score = 0
    private var lives = 3
    private var gameOver = false
    private var initialized = false

    private var lastFrameTime = 0L

    private val basketRect = RectF()

    private fun dp(value: Float): Float {
        return value * resources.displayMetrics.density
    }

    override fun onSizeChanged(
        w: Int,
        h: Int,
        oldw: Int,
        oldh: Int
    ) {
        super.onSizeChanged(w, h, oldw, oldh)

        if (w > 0 && h > 0 && !initialized) {
            initialized = true
            resetGame()
        }
    }

    private fun resetGame() {
        score = 0
        lives = 3
        gameOver = false

        ballSpeed = dp(220f)
        ballRadius = dp(14f)
        basketWidth = dp(100f)
        basketHeight = dp(20f)
        basketBottomMargin = dp(35f)

        basketX = width / 2f
        resetBall()
        lastFrameTime = System.nanoTime()
    }

    private fun resetBall() {
        val minX = ballRadius
        val maxX = width.toFloat() - ballRadius

        ballX = if (maxX > minX) {
            Random.nextFloat() * (maxX - minX) + minX
        } else {
            width / 2f
        }

        ballY = -ballRadius
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Background
        canvas.drawColor(Color.rgb(225, 241, 255))

        if (!initialized) return

        // Update the game state
        updateGame()

        // Draw ball
        paint.color = Color.rgb(255, 170, 0)
        canvas.drawCircle(ballX, ballY, ballRadius, paint)

        // Calculate basket position
        val basketTop =
            height - basketBottomMargin - basketHeight

        basketRect.set(
            basketX - basketWidth / 2f,
            basketTop,
            basketX + basketWidth / 2f,
            basketTop + basketHeight
        )

        // Draw basket
        paint.color = Color.rgb(40, 100, 220)
        canvas.drawRoundRect(
            basketRect,
            dp(8f),
            dp(8f),
            paint
        )

        // Draw score
        paint.color = Color.rgb(30, 40, 60)
        paint.textSize = dp(22f)
        paint.textAlign = Paint.Align.LEFT

        canvas.drawText(
            "Score: $score",
            dp(20f),
            dp(38f),
            paint
        )

        canvas.drawText(
            "Lives: $lives",
            dp(20f),
            dp(68f),
            paint
        )

        if (gameOver) {
            drawGameOver(canvas)
        } else {
            // Request the next frame
            postInvalidateDelayed(16)
        }
    }

    private fun updateGame() {
        if (gameOver) return

        val now = System.nanoTime()

        if (lastFrameTime == 0L) {
            lastFrameTime = now
            return
        }

        // Time elapsed since the previous frame
        val deltaTime = (
                (now - lastFrameTime) / 1_000_000_000.0
                ).toFloat().coerceIn(0f, 0.033f)

        lastFrameTime = now

        // Move the ball downwards
        ballY += ballSpeed * deltaTime

        val basketTop =
            height - basketBottomMargin - basketHeight

        val insideBasket =
            ballX >= basketX - basketWidth / 2f &&
                    ballX <= basketX + basketWidth / 2f

        // Check whether the ball reaches the basket
        if (
            insideBasket &&
            ballY + ballRadius >= basketTop &&
            ballY - ballRadius <= basketTop + basketHeight
        ) {
            score++

            // Increase difficulty gradually
            ballSpeed += dp(12f)

            resetBall()
        } else if (ballY - ballRadius > height) {
            // Ball missed the basket
            lives--

            if (lives <= 0) {
                gameOver = true
            } else {
                resetBall()
            }
        }
    }

    private fun drawGameOver(canvas: Canvas) {
        paint.color = Color.argb(175, 0, 0, 0)
        canvas.drawRect(
            0f,
            0f,
            width.toFloat(),
            height.toFloat(),
            paint
        )

        paint.color = Color.WHITE
        paint.textAlign = Paint.Align.CENTER
        paint.textSize = dp(34f)

        canvas.drawText(
            "GAME OVER",
            width / 2f,
            height / 2f - dp(25f),
            paint
        )

        paint.textSize = dp(22f)

        canvas.drawText(
            "Final Score: $score",
            width / 2f,
            height / 2f + dp(15f),
            paint
        )

        paint.textSize = dp(16f)

        canvas.drawText(
            "Tap anywhere to restart",
            width / 2f,
            height / 2f + dp(55f),
            paint
        )
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN,
            MotionEvent.ACTION_MOVE -> {

                if (gameOver) {
                    if (event.action == MotionEvent.ACTION_DOWN) {
                        resetGame()
                        invalidate()
                    }

                    return true
                }

                // Move basket to the finger position
                val halfWidth = basketWidth / 2f

                basketX = event.x.coerceIn(
                    halfWidth.coerceAtMost(width / 2f),
                    (width - halfWidth).coerceAtLeast(width / 2f)
                )

                invalidate()
                return true
            }

            MotionEvent.ACTION_UP -> {
                performClick()
                return true
            }
        }

        return true
    }

    override fun performClick(): Boolean {
        super.performClick()
        return true
    }
}