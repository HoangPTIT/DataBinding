package com.example.hdev.databindingsample.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.hdev.databindingsample.R.layout
import com.example.hdev.databindingsample.data.models.Animals
import com.example.hdev.databindingsample.data.models.User
import com.example.hdev.databindingsample.data.viewmodels.AnimalsViewModel
import com.example.hdev.databindingsample.data.viewmodels.UserViewModel
import com.example.hdev.databindingsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val user by lazy { User("Hoang", 19) }

    private lateinit var binding: ActivityMainBinding

    private val animals by lazy { Animals.build("Dog", "Black") }

    private val userViewModel by lazy { ViewModelProviders.of(this).get(UserViewModel::class.java) }

    private val animalViewModel by lazy { ViewModelProviders.of(this).get(AnimalsViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layout.activity_main)
        binding.lifecycleOwner = this
        binding.user = user
        binding.handlers = HandlersEvent()
        // Two-way binding use Observable Field
        binding.animals = animals
        // Two-way binding use Live Data
        binding.animalModel = animalViewModel
        //* Use LiveData with ViewModel
        binding.userModel = userViewModel
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

        fun handleEventButton(user: User) {
            userViewModel.currentName.value = "Hoang"
        }
    }

    companion object {
        private const val DATA = "DATA"
    }
}
