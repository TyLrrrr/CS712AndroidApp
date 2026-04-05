package com.example.assignment2

import android.content.Intent
import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until
import androidx.test.uiautomator.waitForStableInActiveWindow

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.BeforeClass



/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private lateinit var device: UiDevice


    @Before
    fun useAppContext() {
        // Context of the app under test.
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        //Log.i("Before", "Getting Device")
        // Start from the home screen
        device.pressHome()
        //Log.i("Before", "Press Home")
        // (Optional) Launch your app via Intent or Shell Command
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        //Log.i("Before", "Getting Context")

        val intent = context.packageManager.getLaunchIntentForPackage("com.example.assignment2")
        //Log.i("Before", "Getting Intent")

        context.startActivity(intent)
        //Log.i("Before", "Launching")

        device.waitForStableInActiveWindow()
        //Log.i("Before", "Waiting for Idle")
    }

    @Test
    fun testButtonClick() {
        val button: UiObject2 = device.findObject(By.res("Explicit"))
        //Log.i("Test", "Getting Button")

        button.click()
        //Log.i("Test", "click")
    }

    @Test
    fun engineerchallenge1() {
        testButtonClick()
        val msg1 = device.wait(Until.hasObject(By.text("Device Fragmentation")), 5000)

        assert(msg1)
    }

    @Test
    fun engineerchallenge2() {
        testButtonClick()
        val msg2 = device.wait(Until.hasObject(By.text("OS Fragmentation")), 5000)

        assert(msg2)
    }

    @Test
    fun engineerchallenge3() {
        testButtonClick()
        val msg3 = device.wait(Until.hasObject(By.text("Unstable and Dynamic Environment")), 5000)

        assert(msg3)
    }

    @Test
    fun engineerchallenge4() {
        testButtonClick()
        val msg4 = device.wait(Until.hasObject(By.text("Rapid Changes")), 5000)

        assert(msg4)
    }

    @Test
    fun engineerchallenge5() {
        testButtonClick()
        val msg5 = device.wait(Until.hasObject(By.text("Tool Support")), 5000)

        assert(msg5)
    }

}