# MVPDemo
MVP模式开发，测试demo

MVP(Mode View Presenter)是由mvc演变过来的
M(Mode):业务逻辑和实体模型
V(View):View通常来说是由Activity实现的，它会包含一个Presenter的引用，View要做的就只是在每次有接口调用的时候（比如按钮点击后）调用Presenter的方法。
P(Presenter):主要作为沟通View和Model的桥梁，它从Model层检索数据后，返回给View层，但是不像MVC结构，因为它也可以决定与View层的交互操作。

MVP项目一：登陆账号，返回登录结果
  总结：
      1、Model层：Bean类，PersonBean类，然后再业务逻辑实现类（IPersonBiz接口，LoginRequestCallBack回调接口，PersonBizImp业务逻辑实现类）
          中有登陆方法，同时把登录成功失败状态的接口传递进去；
      2、View层：通过Presenter与View进行交互，需要定义一个接口（ILoginView）;有了接口就可以写ILoginView的实现类activity（MVPTestActivity），
         该activity中包含有，Presenter的实例对象
      3、Presenter层：作为Model和View之间的交互桥梁，在本例中执行的是登陆操作，然后去Model中执行登陆操作，最后将登陆结果返回给View;
         该类中包含有Model和View的引用。