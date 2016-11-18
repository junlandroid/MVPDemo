package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * Created by Administrator on 2016/11/18.
 */
public class JunlDaoGenerator {
    public static void main(String[] args) throws Exception {
        // 正如你所见的，你创建了一个用于添加实体（Entity）的模式（Schema）对象。
        // 两个参数分别代表：数据库版本号与自动生成代码的包路径。
        Schema schema = new Schema(1, "com.zhg.junl.db.entity");

        //当然，如果你愿意，你也可以分别指定生成的 Bean 与 DAO 类所在的目录，只要如下所示：
        //Schema schema = new Schema(1, "de.greenrobot.gjh.bean");
        schema.setDefaultJavaPackageDao("com.zhg.junl.db.dao");

        //默认Java package用来存放生成的entity、DAO文件、test代码。但也可以重新制定test文件的单独路径以及DAO文件的路径
        //schema.setDefaultJavaPackageTest("de.greenrobot.gjh.test");
        //schema.setDefaultJavaPackageDao("de.greenrobot.gjh.dao");

        /**
         * 两个flag，用来标示entity是否是activie以及是否使用keep sections
         * Keep sections：因为entity class在每次generator执行时均会覆盖原来的程序，
         * 为了能够添加用户自定义代码到entity中，需要设置该参数。
         * 只需要把自己的代码添加到下面的KEEP[]块中间就可以了。
         */
        schema.enableKeepSectionsByDefault();
        schema.enableActiveEntitiesByDefault();

        /**
         * schema中可以添加entity，
         * 简单的理解应该是entity对应一个具体的java class，entity可以添加property。
         * Entity通常也是对应一个table。
         * 除了添加property之外，entity也可以添加to-one和to-many关系，即添加一对一的关系和一对多的关系。
         */
        // 一旦你拥有了一个 Schema 对象后，你便可以使用它添加实体（Entities）了。

        /*设备列表 table*/
        addDeviceModel(schema);
//        /*设备维修表 table*/
//        addDeviceRepair(schema);
//        /*设备保养表 table*/
//        addDeviceMainTain(schema);
//        /*设备保养项目 table*/
//        addDeviceMainTainItem(schema);

        // 最后我们将使用 DAOGenerator 类的 generateAll() 方法自动生成代码，此处你需要根据自己的情况更改输出目录（既之前创建的 java-gen)。
        // 其实，输出目录的路径可以在 build.gradle 中设置，有兴趣的朋友可以自行搜索，这里就不再详解。
        //new DaoGenerator().generateAll(schema, "../DaoExample/src/main/java");
        new DaoGenerator().generateAll(schema, "D:\\CompanyProjects\\TestFiles\\MVPDemo\\greeendaodemo\\src\\main\\java");
    }

    /**
     * 设备列表 table
     */
    private static void addDeviceModel(Schema schema){
        Entity deviceList = schema.addEntity("DeviceModel");
        deviceList.addIdProperty();
        deviceList.addStringProperty("deviceid");// 设备ID
        deviceList.addStringProperty("groupid");// 公司jid
        deviceList.addStringProperty("groupname");// 公司名称
        deviceList.addStringProperty("deviceserial");// 设备序列号
        deviceList.addStringProperty("devicetypeid");// 设备类型ID
        deviceList.addStringProperty("devicetypename");// 设备类型
        deviceList.addStringProperty("devicename");// 设备名称
        deviceList.addStringProperty("photo");// 设备图片
        deviceList.addStringProperty("usingtime");// 启用时间
        deviceList.addStringProperty("devicespec");// 设备规格
        deviceList.addStringProperty("devicemodel");// 设备型号
        deviceList.addStringProperty("devicebrand");// 设备品牌
        deviceList.addStringProperty("deviceorigin");// 设备原产地
        deviceList.addStringProperty("devicestorage");// 设备存放地
        deviceList.addStringProperty("deviceusedepartment");// 设备使用部门
        deviceList.addStringProperty("createtime");// 创建时间
        deviceList.addStringProperty("createuser");// 创建者
        deviceList.addStringProperty("deleteflag");// 删除标识
        deviceList.addStringProperty("updatetime");// 更新时间
        deviceList.addStringProperty("updateuser");// 更新者
        deviceList.addStringProperty("nickname");// 责任人
    }
}
