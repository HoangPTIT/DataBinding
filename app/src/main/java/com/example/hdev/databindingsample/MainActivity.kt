package com.example.hdev.databindingsample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.hdev.databindingsample.databinding.ActivityMainBinding
import com.example.hdev.databindingsample.models.User

class MainActivity : AppCompatActivity() {

    private val user by lazy { User("I'm Hoang", 19) }

    private val isMale: Boolean by lazy { true }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.user = user
        binding.handlers = HandlersEvent()
        binding.isMale = isMale
    }

    inner class HandlersEvent {
        /**
         * @Method references
         * + Nếu biểu thức là method reference -> Tạo listener
         * + Nếu biểu thức là null -> Không tạo listener và set null
         * @Compare:
         * @OnClick (View): Biểu thức được kiểm tra lỗi tại compile time.
         * @Param: Tham số của method phải khớp với tham số của listener
         */
        fun handleEventUserName(view: View) {
            Toast.makeText(this@MainActivity, "Method reference", Toast.LENGTH_SHORT).show()
        }

        /**
         * @Listener binding
         * + Biểu thức ràng buộc run khi sự kiện xảy ra.
         * @Param: Chỉ giá trị trả về phải phù hợp với giá trị trả lại mong đợi của listener
         */
        fun handleEventUserAge(user: User) {
            Toast.makeText(this@MainActivity, user.age.toString(), Toast.LENGTH_SHORT).show()
        }

        /**
         *  Can use a lambda expression with more than one parameter.
         */
        fun handleEventCheckBox(user: User, isChecked: Boolean) {
            Toast.makeText(this@MainActivity, isChecked.toString(), Toast.LENGTH_SHORT).show()
        }

        /**
         * Listening to returns a value (not void)
         */
        fun handleButtonConfirmOnLongClick(user: User): Boolean {
            Toast.makeText(this@MainActivity, user.name, Toast.LENGTH_SHORT).show()
            return true
        }
    }
}
