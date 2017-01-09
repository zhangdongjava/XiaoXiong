package com.example.administrator.xiaoxiong.script.copy;


import com.example.administrator.xiaoxiong.bean.LinkBean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dell_2 on 2016/11/19.
 */
public class DiXiaGuCheng extends FuBen {

    Set<String> gws = new HashSet<>();
    LinkBean linkBean;

    public DiXiaGuCheng() {
        gws.add("了望守卫(魂)");
        gws.add("天兵(魂)");
        gws.add("地兵(魂)");
        gws.add("阁楼护卫(魂");
        gws.add("四方守卫(魂)");
        gws.add("太守(魂)");
        gws.add("玄武(魂)");
        gws.add("青龙(魂)");
        gws.add("白虎(魂)");
        gws.add("朱雀(魂)");
    }

    @Override
    public String inClearLine() {
        return null;
    }

    @Override
    public String outClearLine() {
        return null;
    }

    @Override
    public String saveLine() {
        return "魂魄,带兵符";
    }

    @Override
    public void ready() {

    }

    @Override
    public boolean fbRun() {
        htmlUtil.linkName("功能菜单");
        htmlUtil.linkName("神行千里");
        htmlUtil.linkName("地下古城");
        if (htmlUtil.getText().contains("今天你已进入")) {
            ableIn = false;
            lastDate = new Date();
            htmlUtil.linkName("返回游戏");
            return false;
        }
        htmlUtil.linkName("进入古城中心");
        gcdb("上:古城北街↑");
        gcdb("上:废墟↑");
        gcdb("上:废墟↑");
        gcdb("下:废墟↓");
        htmlUtil.linkName("下:古城北街↓");
        gcdb("左:废墟←");
        gcdb("左:废墟←");
        gcdb("左:废墟←");
        gcdb("左:城墙←");
        gcdb("上:城墙↑");
        gcdb("右:废墟→");
        gcdb("右:西北阁→");
        gcdb("左:废墟←");
        gcdb("左:城墙←");
        gcdb("下:城墙↓");
        gcdb("右:废墟→");
        gcdb("右:废墟→");
        gcdb("右:废墟→");
        gcdb("上:废墟↑");
        gcdb("上:废墟↑");
        gcdb("左:废墟←");
        gcdb("左:将军府←");
        htmlUtil.linkName("镇边将军", true);
        zhandou();
        gcdb("左:城墙←");
        gcdb("上:西北城角↑");
        gcdb("右:城墙→");
        gcdb("右:城墙→");
        gcdb("右:城墙→");
        gcdb("进入玄武");
        htmlUtil.linkName("左:城墙←");
        htmlUtil.linkName("左:城墙←");
        htmlUtil.linkName("左:城墙←");
        htmlUtil.linkName("左:城墙←");
        htmlUtil.linkName("左:西北城角←");
        htmlUtil.linkName("下:城墙↓");
        htmlUtil.linkName("右:将军府→");
        htmlUtil.linkName("右:废墟→");
        htmlUtil.linkName("右:废墟→");
        htmlUtil.linkName("下:废墟↓");
        htmlUtil.linkName("下:废墟↓");
        htmlUtil.linkName("右:古城北街→");
        htmlUtil.linkName("下:古城中心↓");
        gcdb("右:古城东街→");
        gcdb("上:废墟↑");
        gcdb("上:废墟↑");
        gcdb("上:废墟↑");
        gcdb("右:废墟→");
        gcdb("右:废墟→");
        gcdb("下:太守府↓");
        gcdb("左:东北阁←");
        htmlUtil.linkName("右:太守府→");
        htmlUtil.linkName("上:废墟↑");
        htmlUtil.linkName("左:废墟←");
        htmlUtil.linkName("左:废墟←");
        htmlUtil.linkName("左:废墟←");
        htmlUtil.linkName("下:废墟↓");
        htmlUtil.linkName("下:废墟↓");
        htmlUtil.linkName("下:废墟↓");
        htmlUtil.linkName("下:古城东街↓");
        gcdb("右:废墟→");
        gcdb("上:废墟↑");
        gcdb("右:废墟→");
        gcdb("右:城墙→");
        gcdb("进入青龙");
        gcdb("上:城墙↑");
        gcdb("上:城墙↑");
        gcdb("上:城墙↑");
        gcdb("上:东北城角↑");
        gcdb("左:城墙←");
        gcdb("左:城墙←");
        gcdb("左:城墙←");
        htmlUtil.linkName("右:城墙→");
        htmlUtil.linkName("右:城墙→");
        htmlUtil.linkName("右:东北城角→");
        htmlUtil.linkName("下:城墙↓");
        htmlUtil.linkName("下:城墙↓");
        htmlUtil.linkName("下:城墙↓");
        htmlUtil.linkName("左:废墟←");
        gcdb("下:废墟↓");
        gcdb("左:废墟←");
        htmlUtil.linkName("左:古城东街←");
        htmlUtil.linkName("左:古城中心←");
        gcdb("左:古城西街←");
        gcdb("左:废墟←");
        gcdb("左:废墟←");
        gcdb("下:废墟↓");
        gcdb("下:废墟↓");
        gcdb("下:废墟↓");
        gcdb("下:废墟↓");
        gcdb("右:废墟→");
        gcdb("下:城墙↓");
        gcdb("左:城墙←");
        gcdb("左:西南城角←");
        gcdb("上:城墙↑");
        gcdb("上:城墙↑");
        gcdb("上:城墙↑");
        gcdb("进入白虎");
        htmlUtil.linkName("下:城墙↓");
        htmlUtil.linkName("下:城墙↓");
        htmlUtil.linkName("下:城墙↓");
        htmlUtil.linkName("下:城墙↓");
        htmlUtil.linkName("下:西南城角↓");
        htmlUtil.linkName("右:城墙→");
        htmlUtil.linkName("右:城墙→");
        htmlUtil.linkName("上:废墟↑");
        htmlUtil.linkName("左:废墟←");
        htmlUtil.linkName("上:废墟↑");
        htmlUtil.linkName("上:废墟↑");
        htmlUtil.linkName("上:废墟↑");
        htmlUtil.linkName("右:废墟→");
        htmlUtil.linkName("右:古城西街→");
        gcdb("下:废墟↓");
        gcdb("左:废墟←");
        gcdb("下:西南阁↓");
        gcdb("右:废墟→");
        gcdb("下:废墟↓");
        gcdb("下:城墙↓");
        htmlUtil.linkName("上:废墟↑");
        htmlUtil.linkName("上:废墟↑");
        htmlUtil.linkName("左:西南阁←");
        htmlUtil.linkName("上:废墟↑");
        htmlUtil.linkName("右:废墟→");
        htmlUtil.linkName("上:古城西街↑");
        htmlUtil.linkName("右:古城中心→");
        gcdb("下:古城南街↓");
        gcdb("右:废墟→");
        gcdb("右:废墟→");
        gcdb("右:废墟→");
        gcdb("右:废墟→");
        gcdb("右:城墙→");
        gcdb("下:城墙↓");
        gcdb("下:城墙↓");
        gcdb("下:东南城角↓");
        htmlUtil.linkName("上:城墙↑");
        htmlUtil.linkName("上:城墙↑");
        htmlUtil.linkName("上:城墙↑");
        htmlUtil.linkName("左:废墟←");
        htmlUtil.linkName("左:废墟←");
        gcdb("下:东南阁↓");
        gcdb("下:废墟↓");
        gcdb("下:城墙↓");
        gcdb("右:城墙→");
        gcdb("上:废墟↑");
        gcdb("上:废墟↑");
        htmlUtil.linkName("下:废墟↓");
        htmlUtil.linkName("下:城墙↓");
        htmlUtil.linkName("左:城墙←");
        htmlUtil.linkName("上:废墟↑");
        htmlUtil.linkName("上:东南阁↑");
        gcdb("左:废墟←");
        gcdb("左:废墟←");
        gcdb("下:废墟↓");
        gcdb("右:废墟→");
        gcdb("下:城墙↓");
        gcdb("进入朱雀");
        return false;
    }

    private void gcdb(String action) {
        htmlUtil.linkName(action);
        for (String gw : gws) {
            linkBean = htmlUtil.linkName(gw, true);
            if (linkBean.isSuccess()) {
                break;
            }
        }
        if (!linkBean.isSuccess()) return;
        zhandou();
    }

    private void gcdb() {
        htmlUtil.linkName("古城地兵(魂", true);

    }

    private void zhandou() {
        htmlUtil.linkName("攻击", true);
        while (htmlUtil.exitsName("普通攻击")) {
            htmlUtil.linkName("普通攻击");
        }
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("返回游戏");
    }

}
