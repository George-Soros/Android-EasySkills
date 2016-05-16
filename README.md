# Android-EasySkills
集合了android开发中的小技巧，和遇到的坑，各种问题的分析等，代码在其中，以及详细的注释，easy copy！

**1:  application oncreate 执行一次**

坑点:  当manifest中有设置了多个进程是，例如： process 这样的

ps:  EasyApplication/getProcessName

**2:“再次点击退出程序”**

坑点:  通过时间间隔的判断最好

ps:  MainActivity/onkeydown

**3： 自动弹出输入法软键盘**

坑点：需要加入延时来开启，不然无效

ps:  EditTextUtils/getSoftKey

**4:   MD5  加密**

ps:  CommonUtils/getMD5

**5:  单例模式, 用的比较多的"双重效验锁写法"**

截图

ps:  Singleton.class

**6:  设置不可点击，且变灰**

TextViewUtils/setNotClick

**7:  getactivtiy()  为空的情况**

ps: ContentFragment.class

**8:  android 6.0 的sdk中找不到 org.apache.http 的包了, 如果还想使用，需要添加如下的代码**

解决:  

eclipse 下libs里添加org.apache.http.legacy.jar
studio   下在相应的module下的build.gradle中加入：
android {
useLibrary 'org.apache.http.legacy'
}

**9:   字符串加变量 "%1$s" 的写法**

xml的写法

<string name="client_update_version">更新版本:%1$s</string>

代码中调用的写法, 使用String.format 来处理

versionCode.setText(String.format(context.getString(R.string.client_update_version),
        String.valueOf("200")));

**10: 计算filesize**
 
Formatter.formatShortFileSize(context, 1024000)

得到：0.98MB

待更新...












参考:

http://wuxiaolong.me/2015/08/10/android-small-knowledge-base/

http://jayfeng.com/2016/03/18/%E4%BD%A0%E5%BA%94%E8%AF%A5%E7%9F%A5%E9%81%93%E7%9A%84%E9%82%A3%E4%BA%9BAndroid%E5%B0%8F%E7%BB%8F%E9%AA%8C/

http://www.jianshu.com/p/d9143a92ad94









