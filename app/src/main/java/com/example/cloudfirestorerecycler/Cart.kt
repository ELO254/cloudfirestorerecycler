package com.example.cloudfirestorerecycler

object Cart {
    var m = mutableListOf<Items>()

    fun addItem(items: Items){
        m.add(items)
    }

    fun getAmount(): Long {
        return m.sumBy { it.amount?.toInt() ?:0 }.toLong()
    }

    fun getList():List<Items>{
        return m.toList()
    }

    fun removeItem(items: Items){
        m.remove(items)
    }


}