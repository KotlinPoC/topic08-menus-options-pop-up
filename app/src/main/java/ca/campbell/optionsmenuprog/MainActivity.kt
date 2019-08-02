package ca.campbell.optionsmenuprog

/**
 * This illustrates dynamic  creation of an Option Menu
 * It also illustrates creating a Pop Up Menu
 *
 * The final type of menu in android, Context Menu is not implemented here
 * but will be shown in later code samples.
 *
 * Also I am playing fast and loose with the mediaplayer so it may crash
 * Check here for proper use
 * http://developer.android.com/reference/android/media/MediaPlayer.html
 *
 * @author Tricia
 *
 * Muppet sounds from http://www.soundboard.com/sb/The_Muppets_Sounds
 */

import android.media.MediaPlayer
import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.SubMenu
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast

class MainActivity : Activity() {
    private var mp: MediaPlayer? = null

    private val handleMenu = PopupMenu.OnMenuItemClickListener { item ->
        // Handle pop up menu item clicks here.
        when (item.itemId) {
            R.id.kermit -> {
                startMediaPlayer(R.raw.kermitthemuppetshow)
                Log.d(TAG, "kermit")
                true
            }
            R.id.piggy -> {
                startMediaPlayer(R.raw.piggiesorry)
                Log.d(TAG, "piggy")
                true
            }
            R.id.fozzie -> {
                startMediaPlayer(R.raw.fozziesoembarassed)
                Log.d(TAG, "fozzie")
                true
            }
            R.id.cookie -> {
                startMediaPlayer(R.raw.cookiemonstercanmehaveacookie)
                Log.d(TAG, "cookie")
                true
            }

            else -> false
        } // switch
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // set default
        mp = null
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        // public abstract MenuItem add (int groupId, int itemId, int order, CharSequence title)
        val dogMenu = menu.addSubMenu(R.string.dogs)
        dogMenu.add(Menu.NONE, MENU_BIGDOGS, Menu.NONE, R.string.bigdogs)
        dogMenu.add(Menu.NONE, MENU_LITTLEDOGS, Menu.NONE, R.string.littledogs)
        menu.add(Menu.NONE, MENU_CRICKETS, Menu.NONE, R.string.crickets)
        val catMenu = menu.addSubMenu(R.string.cats)
        catMenu.add(Menu.NONE, MENU_CATS, Menu.NONE, R.string.cat)
        catMenu.add(Menu.NONE, MENU_LION, Menu.NONE, R.string.lion)
        catMenu.add(Menu.NONE, MENU_TIGER1, Menu.NONE, R.string.tiger1)
        catMenu.add(Menu.NONE, MENU_TIGER2, Menu.NONE, R.string.tiger2)
        catMenu.add(Menu.NONE, MENU_CATHISS, Menu.NONE, R.string.cathiss)
        menu.add(Menu.NONE, MENU_CHICKENS, Menu.NONE, R.string.chickens)
        menu.add(Menu.NONE, MENU_PIGS, Menu.NONE, R.string.pigs)
        menu.add(Menu.NONE, MENU_STOP, Menu.NONE, R.string.shutup)
        return super.onCreateOptionsMenu(menu)
        // not using showAsAction() so they do not show on the actionbar
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            MENU_CRICKETS -> {
                startMediaPlayer(R.raw.crickets)
                Toast.makeText(this, "crickets", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "crickets")
                return true
            }
            MENU_BIGDOGS -> {
                startMediaPlayer(R.raw.bigdog)
                Toast.makeText(this, "big dogs", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "big dogs")
                return true
            }

            MENU_LITTLEDOGS -> {
                startMediaPlayer(R.raw.littledog)
                Toast.makeText(this, "little dogs", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "little dogs")
                return true
            }

            MENU_CATS -> {
                startMediaPlayer(R.raw.meow)
                Toast.makeText(this, "cats", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "cats")
                return true
            }

            MENU_CATHISS -> {
                startMediaPlayer(R.raw.cathiss)
                Toast.makeText(this, "cats", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "cats")
                return true
            }
            MENU_LION -> {
                startMediaPlayer(R.raw.lion)
                Toast.makeText(this, "cats", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "cats")
                return true
            }
            MENU_TIGER1 -> {
                startMediaPlayer(R.raw.tigergrowl)
                Toast.makeText(this, "cats", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "cats")
                return true
            }

            MENU_CHICKENS -> {
                startMediaPlayer(R.raw.chicken)
                Toast.makeText(this, "chickens", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "chickens")
                return true
            }

            MENU_PIGS -> {
                startMediaPlayer(R.raw.pig)
                Toast.makeText(this, "pigs", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "pigs")
                return true
            }

            MENU_STOP -> {
                stopMediaPlayer()
                Toast.makeText(this, "Quiet down now!", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "stop mediaplayer")
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun newActivity(view: View) {
        val i = Intent(this, Activity2::class.java)
        startActivity(i)
    }

    /**
     * Implement popup menu
     *
     * @param view
     */
    fun popupGrover(view: View) {
        val popup = PopupMenu(this, view)
        popup.setOnMenuItemClickListener(handleMenu)
        popup.inflate(R.menu.grovermenu)
        popup.show()
    }

    /**
     * Stop the mediaplayer then start with sound
     * @param R.raw.name sound file
     */
    private fun startMediaPlayer(sound: Int) {
        stopMediaPlayer()
        mp = MediaPlayer.create(this, sound)
        mp!!.isLooping = true
        mp!!.start()
    } // startMediaPlayer()

    /**
     * Stop the mediaplayer if it is running
     */

    fun stopMediaPlayer() {
        if (mp != null && mp!!.isPlaying) {
            mp!!.stop()
            mp!!.release()
        }

    }

    companion object {
        private val TAG = "MENUOPTPOP"

        private val MENU_CRICKETS = 0
        private val MENU_DOGS = 1
        private val MENU_BIGDOGS = 2
        private val MENU_LITTLEDOGS = 3
        private val MENU_CATS = 4
        private val MENU_CHICKENS = 5
        private val MENU_PIGS = 6
        private val MENU_STOP = 7
        private val MENU_CATHISS = 8
        private val MENU_TIGER1 = 9
        private val MENU_TIGER2 = 10
        private val MENU_LION = 11
    }
}  //MainActivity
