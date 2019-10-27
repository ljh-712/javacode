## 类和对象：

**1、关于面向对象**：***是一种思考问题的方式，一种思想，处理大问题，（c语言处理的小问题）它注重的是对象。*
**2、oop**:**指的是==面向对象程序设计语言==，我们所学的java就是一个典型的面向对象语言，它的三大特性：==继承性，多态性，封装性。==
**3、什么是类，什么是对象？**
      简单来说==类就是一个模板，而对象则是由模板产生的样本==（比如做月饼的模子是一个类，而通过模板可以做出月饼，月饼是一个实体，也就是对象，一个模子可以实例化无数个对象）。所以==对象是类的实例化。一个类可以产生多个对象。类是一类对象的统称==。
**4、创建一个类和对类进行实例化**：类中的元素称为：成员属性。类中的函数称为：成员方法

```c
class Student {
    public String name;//成员属性
    public int age;//成员属性
    public String sex;//成员属性
    public void study() {//成员方法
        System.out.println("学习");
    }
    public void eat() {//成员方法
        System.out.println("吃饭");
    }
}
public class DemoTest {
    public static void main(String[] args) {
        Student student=new Student();//实例化student对象
        student.eat();
        student.study();
    }
}
```

1、>==new 关键字用于创建一个对象的实例，（也就是说new一个对象）==。
*2、>**使用 **  .    来访问对象中的属性和方法。*
*3、>同一个类可以创建多个实例。*
*5、类的成员可以包含：字段、方法、接口、代码块，内部类等。*
*6、>字段：方法外部定义的变量、用于描述方法外部包含哪些数据。*

```c
class Person {
    public String name;   // 字段
    public int age; }
class Test {
    public static void main(String[] args) {
        Person person = new Person(); 
         System.out.println(person.name);
        System.out.println(person.age);
    }
 }
输出 null   0
```

==对于一个对象的字段如果没有显式设置初始值, 那么会被设置一个默认的初值。==对于各种数字类型，默认值为0，对于boolean类型，默认值为false,对于引用类型（类、数组、String、等）==int/byte/short/long/->0  、double->0.0d、float->0.0f  char->'\u0000'、 boolean->false、引用类型->null
null 在java中表示一个无效的对像、类似于c语言中的空指针，如果对null进行 .   操作，就会引发空指针异常： java.lang.NullPointerException 
····使用 . 访问对象的字段==

*2、>方法：描述对象的行为*

```c
class Student2 {
    public String name="庭深";
    public int age=18;
    public void show() {//这里的show就是一个展示的方法
        System.out.println("我叫"+name+"今年"+age+"岁");
    }
}
public class DemoTest {
    public static void main(String[] args) {
        Student2 student=new Student2();
        student.show();
    }
}
//打印：我叫庭深今年18岁。
Student2 student2=new Student2();
        student2.name="张飞";
        student2.age=888;
        student2.show();
也可以创建其他实例，show行为也会发生改变//打印：我叫张飞今年888岁
```

*3、>static关键字*

~~==修饰属性：Java静态属性和类相关, 和具体的实例无关. 换句话说, 同一个类的不同实例共用同一个静态属性==

```c
class Test {
    public int a;
    public static int count;
}
public class DemoTest {
    public static void main(String[] args) {
        Test t=new Test();
        t.a++;
        Test.count++;
        System.out.println(t.a);//1
        System.out.println(Test.count);//1
        Test t2=new Test();
        t2.a++;
        Test.count++;
        System.out.println(t2.a);//1
        System.out.println(Test.count);//2count是一个静态属性，两个实例公用
   }
```
>静态成员的访问通过   类名  .  属性   《也可以通过对象  .  类名去访问，但是不推荐》、所有被static修饰的不管是方法还是成员，他的调用或访问只需要通过类名进行调用。也就是说==所有被static修饰的不管是方法还是成员、都不依赖对象。
——》》为什么main()函数是static ?--==因为如果不是静态的，那么main函数的调用需要对象==。
>在静态方法的内部不能访问非静态成员：---》因为静态的方法不依赖于对象，对象是否产生并不影响调用静态方法，而非静态数据成员的调用依赖于对象，对象被实例化后，new了一个 Test t=new Test();Test还是访问静态的==
>修饰方法：如果在任何方法上应用 static 关键字，此方法称为静态方法。
静态方法属于类，而不属于类的对象。 可以直接调用静态方法，而无需创建类的实例。 静态方法可以访问静态数据成员，并可以更改静态数据成员的值


>** 静态方法和实例无关, 而是和类相关. 因此这导致了两个情况:
==静态方法不能直接使用非静态数据成员或调用非静态方法(非静态数据成员和方法都是和实例相关的). this和super两个关键字不能在静态上下文中使用(this 是当前实例的引用, super是当前实例父类实例的引用, 也 是和当前实例相关).==

```c
class Person {
     public int age;//实例变量    存放在对象内
     public String name;//实例变量
     public String sex;//实例变量 
    public static int count;//类变量也叫静态变量，
    编译时已经产生，属于类本身，且只有一份。存放在方法区
     public final int SIZE = 10;//被final修饰的叫常量
     ，也属于对象。 被final修饰，后续不可更改，存放在方法区
     public static final int  COUNT = 99;//静态的常量，属于类本身，只有一份  被final修饰，后续不可更改     //实例成员函数          public void eat() {
        int a = 10;//局部变量
         System.out.println("eat()!");
       }
     //实例成员函数
      public void sleep() {
        System.out.println("sleep()!");
       } 
    //静态成员函数
      public static void staticTest(){ 
         //不能访问非静态成员
         //sex = "man"; error 
        System.out.println("StaticTest()");
      }
 } public class Main{  public static void main(String[] args) { 
        //产生对象 实例化对象        
 Person person = new Person();//person为对象的引用
         System.out.println(person.age);//默认值为0
         System.out.println(person.name);//默认值为null 
        //System.out.println(person.count);//会有警告! 
        //正确访问方式：         System.out.println(Person.count);
         System.out.println(Person.COUNT);
         Person.staticTest();
         //总结：所有被static所修饰的方法或者属性，全部不依赖于对象
         person.eat(); 
        person.sleep();
   }
 } 
```

**5、封装*****：***封装的本质就是让类的调用者不必太多的了解类的实现者是如何实现类的, 只要知道如何使用类就行了. 这样就==降低了类使用者的学习和使用成本, 从而降低了复杂程度.==
*1> private实现封装*

```c
class Student {
    private String name="李明";
    private int age;//使用 private 封装属性, 并提供 public 方法供类的调用者使用
    public void show() {//字段已经使用 private 来修饰. 类的调用者(main方法中)不能直接使用. 而需要借助 show 方法
        System.out.println(name);
    }
}
    public static void main(String[] args) {
        Student student=new Student();
        student.name="uu";name是私有数据，不能直接访问
        System.out.println(name);
        student.show();
    }
}
```
>此时字段已经使用 private 来修饰. 类的调用者(main方法中)不能直接使用. 而需要借助 show 方法. 此时类的使 用者就不必了解 Person 类的实现细节. 同时如果类的实现者修改了字段的名字, 类的调用者不需要做出任何修改(类的调用者根本访问不到 name, age 这样的字段). 
private 不光能修饰字段, 也能修饰方法 通常情况下我们会把字段设为 private 属性, 但是方法是否需要设为 public, 就需要视具体情形而定.
2>当我们使用 private 来修饰字段的时候, 就无法直接使用这个字段了.所以我们应该使用getter/setter方法（idea快捷键》》alt+insert    长按shift可多选）

```c

class Student {
    private String name;
    private int age;

    public String getName() {//getName 即为 getter 方法, 表示获取这个成员的值
        return name;
    }

    public void setName(String name) {//setName 即为 getter 方法, 表示修改这个成员的值
        this.name = name;//this引用，表示调用该方法的对象
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;//this引用，表示调用该方法的对象
    }
    public void show() {
        System.out.println(name+age);
    }
}

public class DemoTest {
    public static void main(String[] args) {
        Student student=new Student();
        student.setName("庭深");
        student.setAge(19);
        String name=student.getName();
        int age=19;
        System.out.println(name);
        System.out.println(age);
        student.show();
    }
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191023131157138.png)
**==注意如果属性是私有的，就不能直接用 . 访问了如果需要获取或者修改这个 private 属性, 就需要使用 getter / setter 方法==. 
**==字段 vs 属性==
>我们通常将类的数据成员称为 "字段(?eld)" , 如果该字段同时提供了 getter / setter 方法, 那么我们也可以将它 称为 "属性(property )"


**5、构造方法：** 使用关键字new实例化新对象时会被自动调用,== 用于完成初始化操作. 方法名和类名一样，没有返回值==。
*1、>如果在实现一个类时==没有写构造方法==，那么编译器会==自动生成一个无参构造方法==，但是，如果你自己写了一个构造方法，那么编译器将不会自动生成。*
```c
class Person {
    private int age;
    private String name;

    public Person() {//默认构造方法
        this.name = "xx";
        this.age = 15;
    }
    public Person(String name,int age) {//两个参数的构造方法
        this.name=name;
        this.age=age;
    }
    public void show() {
        System.out.println(name+age);
    }
}


public class DemoTest {
    public static void main(String[] args) {
        Person person =new Person();//调用第一个构造方法
        //System.out.print(person);
        person.show();
        Person person1=new Person("lim",15);//调用第二个构造方法
        person1.show();
    }
```

*2、>**this关键字*
==this代表当前对象的引用==
>为什莫说this是当前对象的引用？
>==对象的创建有两步：第一：分配内存空间，第二：调用构造函数。如果用this说明当前对象还没有构造好==

```c
class Person {
    private String name;
    private int age;
    private String sex;

    public Person() {
        //System.out.println();
        this("xiao",15,"女");//必须放在第一行显示
    }
    public Person(String name,int age,String sex) {
        this.name=name;
        this.age=age;
        this.sex=sex;
    }
    public void show() {
        System.out.println(name+age+sex);
    }
}
public class DemoTest {
    public static void main(String[] args) {
        Person person=new Person();
        person.show();
    }
}
```
**6. 代码块**
>使用 {} 定义的一段代码.
根据代码块定义的位置以及关键字，又可分为以下四种：

>普通代码块 ：：定义在方法中的代码块




>构造块：定义在类中的代码块(不加修饰符)。也叫：实例代码块。构造代码块一般用于初始化实例成员变量。

> 静态块


==静态代码块执行优先于实例代码块、实例代码块执行优先于构造方法、如果有一个静态代码块，一个静态属性，谁在前谁先执行==

```java
class Person{
    private String name;
    private int age;
    public static int count = 10;

    //静态代码块-》初始化 静态的数据成员
    static {
        count = 9999999;
        //this.name = "chang";
        System.out.println("static{}");
    }

    //实例代码块 --》 初始化类的实例数据成员
    {
        this.name = "caocao";
        this.age = 99;
        //count = 8888;
        System.out.println("instance{}");
    }
```

**## 7、匿名对象**

>匿名只是表示没有名字的对象. 没有引用的对象称为匿名对象. 匿名对象只能在创建对象时使用. 如果一个对象只是用一次, 后面不需要用了, 可以考虑使用匿名对象.

```java
class Person {
     private String name;     
     private int age;    
     public Person(String name,int age) {         
     this.age = age;         
     this.name = name;     
     }     
     public void show() {         
     System.out.println("name:"+name+" " + "age:"+age);     } } 
 
public class Main { 
 
    public static void main(String[] args) {         
    new Person("caocao",19).show();//通过匿名对象调用方法     
    } 
 } 
 
// 执行结果 name：caocao age：1
```

