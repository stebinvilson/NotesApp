package com.example.notesapp.Viewmodels

import android.content.Context
import androidx.lifecycle.*
import com.example.notesapp.Repository.UserRepository
import com.example.notesapp.room.NoteDatabase
import com.example.notesapp.Model.UserEntity
import kotlinx.coroutines.launch

class UserViewmodel(var context : Context) : ViewModel() {

    private var repository : UserRepository

    var loggeduser :MutableLiveData<UserEntity> = MutableLiveData()

        //  private val checkuser : MutableLiveData<UserEntity> =

    init {
        val dao = NoteDatabase.getInstance(context).userdao()
        repository = UserRepository(dao)

    }

    var empList = repository.data


    fun adduser(user : UserEntity){
        viewModelScope.launch {
            repository.addUser(user)

        }
    }

    fun getall() : LiveData<List<UserEntity>> {

        viewModelScope.launch {
        //    empList =  repository.getdata()

        }
        return empList
    }

    fun checkuser(username: String, password: String) {
        viewModelScope.launch {
            loggeduser.value= repository.loggeduser(username, password)

        }
    }




//    private val _sendOTPResponse: MutableLiveData<Resource<ArrayList<SendOTPResponse>>> = MutableLiveData()
//    val sendOTPResponse: LiveData<Resource<ArrayList<SendOTPResponse>>> get() = _sendOTPResponse
//
//    suspend fun sendOTP(sendOTPRequest: SendOTPRequest): Resource<ArrayList<SendOTPResponse>> {
//        sendOTPRequest.MethodName = AppConstants.APIConstants.SEND_OTP_METHOD
//        return safeApiCall { apiService.sendOTP(sendOTPRequest) }
//    }
//
//
//    fun sendOTP(mobileNumber: String, isLogin: Boolean) {
//        this.mobileNumber = mobileNumber
//        if (validateMobileNumber(mobileNumber)) {
//            viewModelScope.launch {
//                _sendOTPResponse.value = Resource.Loading
//                _sendOTPResponse.value = userRepository.sendOTP(SendOTPRequest(MOBILE = mobileNumber, IsLogin = isLogin))
//            }
//        }
//    }




}