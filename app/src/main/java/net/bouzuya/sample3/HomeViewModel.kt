package net.bouzuya.sample3

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class HomeViewModel(private val _userRepository: UserRepository) : ViewModel() {
    val name = "Home"

    private val _nameText = MutableLiveData<String>()

    private val _userList = MutableLiveData<List<User>>()
    val userList: LiveData<List<User>> = _userList

    val userCount: LiveData<String> = Transformations.map(_userList) { (it?.size ?: 0).toString() }

    init {
        viewModelScope.launch {
            _userList.value = _userRepository.findAll()
        }
    }

    fun insert() = viewModelScope.launch {
        val name = _nameText.value ?: return@launch
        val user = User(0, name)
        _userRepository.insert(user)

        _nameText.value = ""

        _userList.value = _userRepository.findAll()
    }

    fun deleteAll() = viewModelScope.launch {
        _userRepository.deleteAll()

        _userList.value = _userRepository.findAll()
    }

    fun updateNameText(s: String) {
        _nameText.value = s
    }
}
