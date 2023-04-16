package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a0413_tab_7.databinding.ActivityRegisterBinding
import org.json.JSONException
import org.json.JSONObject
//import com.android.volley.Response
//import com.android.volley.toolbox.Volley


class RegisterActivity : AppCompatActivity() {

    val binding by lazy { ActivityRegisterBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var character = 0
        var red = 0
        var blue = 0
        var brown = 0
        var purple = 0
        var yellow = 0

        binding.buttonSignUp.setOnClickListener {
            val name = binding.name.text.toString()
            val id = binding.id.text.toString()
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val passwordCheck = binding.passwordCheck.text.toString()
            val phone = binding.phone.text.toString()

            if (binding.checkBoxRed.isChecked) {
                red = 1
            }
            if (binding.checkBoxBlue.isChecked) {
                blue = 1
            }
            if (binding.checkBoxBrown.isChecked) {
                brown = 1
            }
            if (binding.checkBoxPurple.isChecked) {
                purple = 1
            }
            if (binding.checkBoxYellow.isChecked) {
                yellow = 1
            }

            if (binding.radioButtonHot.isChecked) {
                character = 1
            } else if (binding.radioButtonMiddle.isChecked) {
                character = 2
            } else if (binding.radioButtonCold.isChecked) {
                character = 3
            }

            if (name == "") {
                Toast.makeText(
                    this@RegisterActivity,
                    "이름을 입력하세요.",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (id == "") {
                Toast.makeText(
                    this@RegisterActivity,
                    "아이디를 입력하세요.",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (email == "") {
                Toast.makeText(
                    this@RegisterActivity,
                    "이메일을 입력하세요.",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (password == "") {
                Toast.makeText(
                    this@RegisterActivity,
                    "비밀번호를 입력하세요.",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (passwordCheck == "") {
                Toast.makeText(
                    this@RegisterActivity,
                    "비밀번호를 입력하세요.",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (password != passwordCheck) {
                Toast.makeText(
                    this@RegisterActivity,
                    "비밀번호가 다릅니다.",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (red == 0 && blue == 0 && brown == 0 && purple == 0 && yellow == 0) {
                Toast.makeText(
                    this@RegisterActivity,
                    "선호하는 색을 선택하세요.",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (character == 0) {
                Toast.makeText(
                    this@RegisterActivity,
                    "체질을 선택하세요",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this@RegisterActivity,
                    "11회원 등록에 성공하였습니다.11(가짜)",
                    Toast.LENGTH_SHORT
                ).show()
                //확인용
                println(name)
                println(id)
                println(email)
                println(password)
                println(red)
                println(blue)
                println(brown)
                println(character)
            }
//
//            //4. 할당된 Response로 콜백 처리하는 부분(volley 사용을 위한 R(r)esponseListener 구현 부분)
//            val responseListener: Response.Listener<String> = Response.Listener<String> {
//                //서버로부터 여기서 데이터 받음
//                fun onResponse(response: String) {
//                    //response-> //이거 아님 위에
//                    try {
//                        //서버로부터 받은 데이터는 JSON타입의 객체다.
//                        //응답 성공 시 Register.php에 회원가입 관련 정보를 POST방식으로 보내면 응답결과로 {"success":true} 혹은 {"success":false}를 받는 거임
//                        val jsonObject = JSONObject(response)
//                        //그 중 Key값이 "success"인 것을 가져온다.
//                        val success = jsonObject.getBoolean("success")
//
//                        if(success){  // 회원등록에 성공한 경우(즉, success값이 true인 경우)
//                            Toast.makeText(
//                                this@RegisterActivity,
//                                "회원 등록에 성공하였습니다.",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                            println("성공이래")
//                            //다른 화면으로 돌아가는 부분
//                            val intent = Intent(this@RegisterActivity, ProfileChangeActivity::class.java)
//                            startActivity(intent)
//                        }else{ //회원 가입 실패 시 success값이 false임
//                            Toast.makeText(
//                                this@RegisterActivity,
//                                "회원 등록에 실패하였습니다.",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                            println("실패래")
//                            //return
//                        }
//                    } catch (e: JSONException) {
//                        e.printStackTrace()
//                    }
//                }
//            }
//            // responseListener 끝
//
//
//            //volley 사용법
//            //1.RequestObject를 생성한다. 이때 서버로부터 데이터를 받을 responseListener를 반드시 넘겨준다.
//            val registerRequest =
//                RegisterRequest(name, id, email, password, phone, red, blue, brown, purple, yellow, character,
//                    responseListener)
//            //2.RequestQueue를 생성한다.
//            val queue = Volley.newRequestQueue(this@RegisterActivity)
//            //3.RequsertQueue를 RequestObject에 넘겨준다.
//            queue.add(registerRequest)

        }
    }
}









