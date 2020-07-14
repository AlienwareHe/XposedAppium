package Superappium.xpath.parser.expression.operator;

import Superappium.ViewImage;
import Superappium.xpath.XpathUtil;
import Superappium.xpath.exception.EvaluateException;
import Superappium.xpath.parser.expression.node.AlgorithmUnit;

import java.math.BigDecimal;


/**
 * Created by virjar on 17/6/10.
 *
 * @author virjar
 * @since 0.0.1 乘法运算
 */
@OpKey(value = "*", priority = 30)
public class MultiUnit extends AlgorithmUnit {

    @Override
    public Object calc(ViewImage element) {

        Object leftValue = left.calc(element);
        Object rightValue = right.calc(element);
        if (leftValue == null || rightValue == null) {
            throw new EvaluateException("operate is null,left: " + leftValue + "  right:" + rightValue);
        }
        // 左右都不为空,开始计算
        // step one think as number
        if (leftValue instanceof Number && rightValue instanceof Number) {
            // 都是整数,则执行整数除法
            if (leftValue instanceof Integer && rightValue instanceof Integer) {
                return (Integer) leftValue * (Integer) rightValue;
            }

            // 包含小数,转double执行除法
            if (leftValue instanceof Double || rightValue instanceof Double || leftValue instanceof Float
                    || rightValue instanceof Float) {
                return ((Number) leftValue).doubleValue() * ((Number) rightValue).doubleValue();
            }

            // 包含BigDecimal 转bigDecimal
            if (leftValue instanceof BigDecimal || rightValue instanceof BigDecimal) {
                if (leftValue instanceof BigDecimal && rightValue instanceof BigDecimal) {
                    return ((BigDecimal) leftValue).multiply((BigDecimal) rightValue);
                }

                BigDecimal newLeft = XpathUtil.toBigDecimal((Number) leftValue);
                BigDecimal newRight = XpathUtil.toBigDecimal((Number) rightValue);
                return newLeft.multiply(newRight);
            }

            // 包含长整数,且不包含小数,全部转化为长整数计算
            if (leftValue instanceof Long || rightValue instanceof Long) {
                return ((Number) leftValue).longValue() * ((Number) rightValue).longValue();
            }

            // 兜底,用double执行计算
            return ((Number) leftValue).doubleValue() * ((Number) rightValue).doubleValue();
        }

        throw new EvaluateException(
                "multiply operate must with number parameter left:" + leftValue + " right:" + rightValue);
    }

}
