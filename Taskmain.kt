package com.example.todotask


class Taskmain{

    var id:String?=null
    var title:String?=null
    var date:String?=null

    var description:String?=null
    var status:String?=null


    constructor(){}

    constructor(id:String,title:String?,date:String?,description:String?,status:String?){
        this.id=id
        this.title=title
        this.date=date
        this.description=description
        this.status=status

    }


}