window.onload=function(){

    //获取所有+按钮
    var increment=document.getElementsByClassName("increase");

    for(var i=0;i<increment.length;i++)
    {
        //为a标签添加index属性，用于记录下标
        increment[i].index=i;

        //点击+数量增加的功能函数
        increment[i].onclick=function()
        {
            var flag=this.index;
            //获取当前a标签对应的数量框
           var q=document.getElementsByClassName("quantity")[flag];

           var newvalue=parseInt(q.value)+1;

           //用q.value=parseInt(q.value)+1
           //会导致数值只在点击的一瞬间发生变化，然后又跳回1
           q.setAttribute('value',newvalue);

           //更新此商品对应的‘小计’
           changeSum(flag,newvalue);
        }
    }

    //获取所有-按钮
    var decrement=document.getElementsByClassName('decrease');

    //点击-数量减少的功能函数
    for(var j=0;j<decrement.length;j++)
    {
        decrement[j].index=j;

        decrement[j].onclick=function()
        {
            var flag=this.index;
             //获取当前a标签对应的那个数量框
           var q=document.getElementsByClassName("quantity")[flag];

           if(parseInt(q.value)>1)
           {
            var newvalue=parseInt(q.value)-1;

            q.setAttribute('value',newvalue);

            changeSum(flag,newvalue);
           }
        }
    }


    //结算功能
    var calculate=document.getElementById('calculate');

    calculate.onclick=function(){
        var radios=document.getElementsByName('p-radio');

        var sumPrice=0;

        var p=document.getElementsByClassName('onlySum');

        for(var m=0;m<radios.length;m++)
        {
            if(radios[m].checked==true)
            {
                sumPrice=sumPrice+parseInt(p[m].innerHTML);
            }
        }

        document.getElementsByClassName("sum-price")[0].innerHTML=sumPrice;
    }

    
    //提交订单的功能
    var submit=document.getElementById("submit-order");

    submit.onclick=function(){

        var data=[];
        var radios=document.getElementsByName('p-radio');
        var count=document.getElementsByClassName("quantity");
        var items=document.getElementsByClassName("item");

        for(var m=0;m<radios.length;m++)
        {
            if(radios[m].checked==true)
            {
                var item={};
                item.tradeid=items[m].getAttribute('id');
                item.amount=count[m].value;
                
                data.push(item);
            }
        }

        var result=JSON.stringify(data);

        $.ajax({
            type : "post",

            url : '',//后台请求地址

            data : result,

            contentType: "application/json", //如果提交的是json数据类型，则必须有此参数,表示提交的数据类型 

            async : false,//异步请求

            success : function(){         },

            error :function(){alert("订单总额为");   }

        });
    }
}


//更新每个商品的‘小计’
function changeSum(flag,num){
    //获取对应单价所在的标签
    var temp=document.getElementsByClassName("onlyPrice")[flag];

    //获取单价
    var unitPrice=temp.innerHTML;

    //计算新的小计价格
    var newPrice=parseInt(unitPrice)*num;

    var sum=document.getElementsByClassName("onlySum")[flag];

    sum.innerHTML=newPrice;
}


//设置全选/全不选的功能
function setAll(){
    var box=document.getElementById('allchecked');

    var radios=document.getElementsByName('p-radio');

    //alert(box.checked);

    if(box.checked==false)
    {
        for(var i=0;i<radios.length;i++)
        {
            radios[i].checked=false;
        }
    }else{
        for(var i=0;i<radios.length;i++)
        {
            radios[i].checked=true;
        }
    }
}

