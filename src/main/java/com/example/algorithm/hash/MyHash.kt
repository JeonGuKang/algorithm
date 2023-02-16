package com.example.algorithm.hash

class MyHash(size: Int) {

    private var hashTable : Array<Slot?>

    init {
        this.hashTable = Array(size) {null}
    }

    data class Slot(
        var value: String
    )

    private fun hashFunc(key:String) : Int {
        return key[0].code % this.hashTable.size
    }

    fun saveData(key: String, value: String) : Boolean {
        val address = hashFunc(key)
        hashTable[address]?.let {
            hashTable[address]?.value = value
        } ?: let {
            hashTable[address] = Slot(value)
        }
        return true
    }

    fun getData(key: String) : String? {
        val address = hashFunc(key)
        hashTable[address]?.let {
            return it.value
        } ?: return null
    }

}