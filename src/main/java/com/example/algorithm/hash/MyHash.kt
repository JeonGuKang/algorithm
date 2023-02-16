package com.example.algorithm.hash

/**
 * 개방 체이닝 기법
 */
class MyHash(size: Int) {

    private var hashTable : Array<Slot?>

    init {
        this.hashTable = Array(size) {null}
    }

    data class Slot(
        var key: String,
        var value: String,
        var next: Slot? = null
    )

    private fun hashFunc(key:String) : Int {
        return key[0].code % this.hashTable.size
    }

    fun saveData(key: String, value: String) : Boolean {
        val address = hashFunc(key)
        hashTable[address]?.let {
            var findSlot : Slot? = it
            var prevSlot = it
            while (findSlot != null) {
                if(findSlot.key == key) {
                    findSlot.value = value
                    return@let
                } else {
                    prevSlot = findSlot
                    findSlot = findSlot.next
                }
            }
            prevSlot.next = Slot(key, value)
        } ?: let {
            hashTable[address] = Slot(key, value)
        }
        return true
    }

    fun getData(key: String) : String? {
        val address = hashFunc(key)
        hashTable[address]?.let {
            var findSlot: Slot? = it
            while (findSlot != null) {
                if(findSlot.key == key) {
                    return findSlot.value
                } else {
                    findSlot = findSlot.next
                }
            }
            return null
        } ?: return null
    }

}