package com.sam.bindfirestore

import com.google.firebase.firestore.PropertyName

data class MyModel(
    @PropertyName("age") var age: Int,
    @set:PropertyName("username")
    @get:PropertyName("username")var name: String
) {

    constructor() : this(0, "")
}
