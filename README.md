## MVPDemo主要作为练习MVP开发模式及收集一些平时用到的工具类
### MVP开发模式用法总结
MVP(Mode View Presenter)是由mvc演变过来的
M(Mode):业务逻辑和实体模型
V(View):View通常来说是由Activity实现的，它会包含一个Presenter的引用，View要做的就只是在每次有接口调用的时候（比如按钮点击后）调用Presenter的法。
P(Presenter):主要作为沟通View和Model的桥梁，它从Model层检索数据后，返回给View层，但是不像MVC结构，因为它也可以决定与View层的交互操作。

##### MVP项目一：登陆账号，返回登录结果
  总结：
    1.Model层：Bean类，PersonBean类，然后再业务逻辑实现类（IPersonBiz接口，LoginRequestCallBack回调接口，PersonBizImp业务逻辑实现类）中有登陆方法，同时把登录成功失败状态的接口传递进去；
    2.View层：通过Presenter与View进行交互，需要定义一个接口（ILoginView）;有了接口就可以写ILoginView的实现类activity（MVPTestActivity），该activity中包含有，Presenter的实例对象
    3.Presenter层：作为Model和View之间的交互桥梁，在本例中执行的是登陆操作，然后去Model中执行登陆操作，最后将登陆结果返回给View;该类中包含有Model和View的引用。
##### MVP项目二：
  分析：RCVDetailsActivity（M） implement RCVDetailsView（V）, 重写replyStatusUpdateCallBack 跟新UI，M 持有RCVDetailsPresenter（P） 引用presenter，用来



### 收集常用的工具类
  日志，json格式转换，base64/md5/esc等加密解密，netTool网络检测，加载数据进度条，ManagerActivity,IntentSkip,DateTimePickDialogUtil
[link](http://example.com).

关于文件的路径保存com.baital.android.project.readKids.utils.AppFileDirManager，
File操作工具类参考com.baital.android.project.readKids.utils.FileUtils


### 收集常用基础知识
1、UUID.randomUUID().toString()
UUID.randomUUID().toString()是javaJDK提供的一个自动生成主键的方法。UUID(Universally Unique Identifier)全局唯一标识符,是指在一台机器上生成的数字，它保证对在同一时空中的所有机器都是唯一的，是由一个十六位的数字组成,表现出来的形式。
2、在Android应用程序开发的时候，从一个Activity启动另一个Activity并传递一些数据到新的Activity上非常简单，但是当您需要让后台运行的Activity回到前台并传递一些数据可能就会存在一点点小问题。
onNewIntent和PendingIntent都有延迟的意思。
常见的案例[link](http://blog.csdn.net/lihenair/article/details/28892921).
































