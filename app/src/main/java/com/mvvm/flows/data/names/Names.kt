package com.mvvm.flows.data.names

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Names(
    @PrimaryKey
    val fullName: String
) {
    fun displayName(): String {
        val builder = StringBuilder()
        for (i in fullName.indices) {
            if (i == 0 ||
                (fullName[i - 1] == ' ' && fullName[i] != ' ')
            ) {
                builder.append(Character.toUpperCase(fullName[i]))
            } else {
                builder.append(fullName[i])
            }
        }
        return builder.toString()
    }
}
