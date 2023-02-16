package com.example.algorithm.hash

/**
 * 폐쇠 Linear 기법
 */
class MyLinearHash(size: Int) {

    private var hashTable : Array<Slot?>

    init {
        this.hashTable = Array(size) {null}
    }

    private data class Slot(
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
            if(hashTable[address]?.key == key) {
                hashTable[address]?.value = value
                return true
            } else {
                var currAddress = address + 1
                while (hashTable[address] != null) {
                    if(hashTable[currAddress]?.key == key) {
                        hashTable[currAddress]?.value = value
                        return true
                    } else {
                        currAddress++
                        if(currAddress >= hashTable.size) {
                            return false
                        }
                    }
                }
                hashTable[currAddress] = Slot(key, value)
            }
        } ?: let {
            hashTable[address] = Slot(key, value)
        }
        return true
    }

    fun getData(key: String) : String? {
        val address = hashFunc(key)
        hashTable[address]?.let {
            if(hashTable[address]?.key == key) {
                return hashTable[address]?.value
            } else {
                var currAddress = address + 1
                while (hashTable[currAddress] != null) {
                    if(hashTable[currAddress]?.key == key) {
                        return hashTable[currAddress]?.value
                    } else {
                        currAddress++
                        if(currAddress >= hashTable.size) {
                            return null
                        }
                    }
                }
                return null
            }
        } ?: return null
    }
}