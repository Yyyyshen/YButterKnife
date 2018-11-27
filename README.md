# YButterKnife
自定义ButterKnife简单实现

使用了注解加反射原理，遍历上下文中所有属性/方法，如果含有相对应的注解，就通过findViewById拿到view，或是赋值或是通过点击方法invoke。

_本以为很简单，然而看了JW大神的源码后，发现并不光是这样。_

ButterKnife的思路核心点在于生成了对应上下文的`XX_ViewBinding`类，在其中处理findViewById等。

而这个ViewBinding类的生成，是通过继承了`AbstractProcessor`的`ButterKnifeProcessor`实现的，具体可以看源码。
