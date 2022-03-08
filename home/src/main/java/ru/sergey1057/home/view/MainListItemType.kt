package ru.sergey1057.home.view

import androidx.annotation.LayoutRes

interface MainListItemType {

    @LayoutRes
    fun getItemType(): Int
}