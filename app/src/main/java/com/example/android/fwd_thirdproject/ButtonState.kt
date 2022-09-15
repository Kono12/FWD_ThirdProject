package com.example.android.fwd_thirdproject


sealed class ButtonState {
    object Loading : ButtonState()
    object Completed : ButtonState()
}