import net.percederberg.mibble.Mib;
import net.percederberg.mibble.MibLoader;
import net.percederberg.mibble.MibLoaderException;
import net.percederberg.mibble.MibValueSymbol;

import java.io.File;
import java.io.IOException;

/**
 * Created by MyPC on 2017/6/12.
 *
 * 使用三方插件解析mib文件
 */
public class LoadMib_demo {

    public static void main(String[] args) throws IOException, MibLoaderException {

        System.out.println("hello loadMIb_demo");

        File mibFile = new File("F:\\OPHYLINK-OSL3030-MIB.my");
        File mibPublicFile = new File("F:\\OPHYLINK-MIB.my");
        String mibName =  mibFile.getName();
        System.out.println("mibFileName"+mibName);
         MibLoader mibLoader = new MibLoader();
         mibLoader.load(mibPublicFile);
         mibLoader.load(mibFile);
        Mib testMib =mibLoader.getMib(mibFile);
         int version = testMib.getSmiVersion();
        MibValueSymbol mibValueSymbol = testMib.getRootSymbol(); //获取全部的节点
       // System.out.println(mibValueSymbol.getOid());
        //System.out.println(testMib.getSymbolByOid(".1.3.6.1.4.1.42861.3.5.3.1.3.8").getValue());
            getAllOidNumbers(mibValueSymbol);

        MibValueSymbol[] s = mibValueSymbol.getChildren();
//        for(MibValueSymbol oid : s)
//        {
//            System.out.println(oid.getOid());
//            System.out.println(oid.getType().getName());
//            System.out.println(oid.getChildCount());
//        }

        //System.out.println(testMib.getSymbolByOid(".1.3.6.1.4.1.42861.3.5.3.1.1").isTableColumn());
//        System.out.println("this file version is :"+version);
       //
        // System.out.println("hander:" + mibHaner);
      // System.out.println("footer"+mibFooter);
    }


    public static void getAllOidNumbers(MibValueSymbol mibValueSymbol)
    {
        int chmuns = mibValueSymbol.getChildCount();
        if(chmuns==0)
        {
            System.out.println(mibValueSymbol.getOid());
        }else {

            MibValueSymbol[] mibs =   mibValueSymbol.getChildren();//获取全部的自己节点
            for(MibValueSymbol s: mibs){
                System.out.println(s.getOid());
                System.out.println(s.isTable());
                getAllOidNumbers(s);
            }
        }

    }
}
