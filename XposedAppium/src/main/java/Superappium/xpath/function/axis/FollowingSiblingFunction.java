package Superappium.xpath.function.axis;


import Superappium.ViewImage;
import Superappium.ViewImages;

import java.util.List;

public class FollowingSiblingFunction implements AxisFunction {
    @Override
    public List<ViewImage> call(ViewImage e, List<String> args) {
        ViewImages rs = new ViewImages();
        ViewImage tmp = e.nextSibling();
        while (tmp != null) {
            rs.add(tmp);
            tmp = tmp.nextSibling();
        }
        return rs;
    }

    @Override
    public String getName() {
        return "following-sibling";
    }
}


