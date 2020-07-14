package Superappium.xpath.function;

import android.util.Log;

import Superappium.SuperAppium;
import Superappium.xpath.function.axis.AncestorFunction;
import Superappium.xpath.function.axis.AncestorOrSelfFunction;
import Superappium.xpath.function.axis.AxisFunction;
import Superappium.xpath.function.axis.ChildFunction;
import Superappium.xpath.function.axis.DescendantFunction;
import Superappium.xpath.function.axis.DescendantOrSelfFunction;
import Superappium.xpath.function.axis.FollowingSiblingFunction;
import Superappium.xpath.function.axis.FollowingSiblingOneFunction;
import Superappium.xpath.function.axis.ParentFunction;
import Superappium.xpath.function.axis.PrecedingSiblingFunction;
import Superappium.xpath.function.axis.SiblingFunction;
import Superappium.xpath.function.filter.AbsFunction;
import Superappium.xpath.function.filter.BooleanFunction;
import Superappium.xpath.function.filter.ConcatFunction;
import Superappium.xpath.function.filter.ContainsFunction;
import Superappium.xpath.function.filter.FalseFunction;
import Superappium.xpath.function.filter.FilterFunction;
import Superappium.xpath.function.filter.FirstFunction;
import Superappium.xpath.function.filter.LastFunction;
import Superappium.xpath.function.filter.LowerCaseFunction;
import Superappium.xpath.function.filter.MatchesFunction;
import Superappium.xpath.function.filter.NameFunction;
import Superappium.xpath.function.filter.NotFunction;
import Superappium.xpath.function.filter.NullToDefaultFunction;
import Superappium.xpath.function.filter.PositionFunction;
import Superappium.xpath.function.filter.PredicateFunction;
import Superappium.xpath.function.filter.RootFunction;
import Superappium.xpath.function.filter.SipSoupPredicteJudgeFunction;
import Superappium.xpath.function.filter.StringFunction;
import Superappium.xpath.function.filter.StringLengthFunction;
import Superappium.xpath.function.filter.SubstringFunction;
import Superappium.xpath.function.filter.ToDoubleFunction;
import Superappium.xpath.function.filter.ToIntFunction;
import Superappium.xpath.function.filter.TrueFunction;
import Superappium.xpath.function.filter.TryExeptionFunction;
import Superappium.xpath.function.filter.UpperCaseFunction;
import Superappium.xpath.function.select.AttrFunction;
import Superappium.xpath.function.select.SelectFunction;
import Superappium.xpath.function.select.SelfFunction;
import Superappium.xpath.function.select.TagSelectFunction;
import Superappium.xpath.function.select.TextFunction;

import java.util.HashMap;
import java.util.Map;

public class FunctionEnv {
    private static Map<String, SelectFunction> selectFunctions = new HashMap<>();
    private static Map<String, FilterFunction> filterFunctions = new HashMap<>();
    private static Map<String, AxisFunction> axisFunctions = new HashMap<>();

    static {
        registerAllSelectFunctions();
        registerAllFilterFunctions();
        registerAllAxisFunctions();

    }

    public static SelectFunction getSelectFunction(String functionName) {
        return selectFunctions.get(functionName);
    }

    public static FilterFunction getFilterFunction(String functionName) {
        return filterFunctions.get(functionName);
    }

    public static AxisFunction getAxisFunction(String functionName) {
        return axisFunctions.get(functionName);
    }

    public synchronized static void registerSelectFunction(SelectFunction selectFunction) {
        if (selectFunctions.containsKey(selectFunction.getName())) {
            Log.w(SuperAppium.TAG, "register a duplicate  select function " + selectFunction.getName());
        }
        selectFunctions.put(selectFunction.getName(), selectFunction);
    }

    public synchronized static void registerFilterFunction(FilterFunction filterFunction) {
        if (filterFunctions.containsKey(filterFunction.getName())) {
            Log.w(SuperAppium.TAG, "register a duplicate  filter function " + filterFunction.getName());
        }
        filterFunctions.put(filterFunction.getName(), filterFunction);
    }

    public synchronized static void registerAxisFunciton(AxisFunction axisFunction) {
        if (axisFunctions.containsKey(axisFunction.getName())) {
            Log.w(SuperAppium.TAG, "register a duplicate  axis function " + axisFunction.getName());
        }
        axisFunctions.put(axisFunction.getName(), axisFunction);
    }

    private static void registerAllSelectFunctions() {
        registerSelectFunction(new AttrFunction());
        registerSelectFunction(new SelfFunction());
        registerSelectFunction(new TagSelectFunction());
        registerSelectFunction(new TextFunction());
    }

    private static void registerAllFilterFunctions() {
        registerFilterFunction(new AbsFunction());
        registerFilterFunction(new BooleanFunction());
        registerFilterFunction(new ConcatFunction());
        registerFilterFunction(new ContainsFunction());
        registerFilterFunction(new FalseFunction());
        registerFilterFunction(new FirstFunction());
        registerFilterFunction(new LastFunction());
        registerFilterFunction(new LowerCaseFunction());
        registerFilterFunction(new MatchesFunction());
        registerFilterFunction(new NameFunction());
        registerFilterFunction(new NotFunction());
        registerFilterFunction(new NullToDefaultFunction());
        registerFilterFunction(new PositionFunction());
        registerFilterFunction(new PredicateFunction());
        registerFilterFunction(new RootFunction());
        registerFilterFunction(new StringFunction());
        registerFilterFunction(new StringLengthFunction());
        registerFilterFunction(new SubstringFunction());
        registerFilterFunction(new Superappium.xpath.function.filter.TextFunction());
        registerFilterFunction(new ToDoubleFunction());
        registerFilterFunction(new ToIntFunction());
        registerFilterFunction(new TrueFunction());
        registerFilterFunction(new TryExeptionFunction());
        registerFilterFunction(new UpperCaseFunction());
        registerFilterFunction(new SipSoupPredicteJudgeFunction());
    }

    private static void registerAllAxisFunctions() {
        registerAxisFunciton(new AncestorFunction());
        registerAxisFunciton(new AncestorOrSelfFunction());
        registerAxisFunciton(new ChildFunction());
        registerAxisFunciton(new DescendantFunction());
        registerAxisFunciton(new DescendantOrSelfFunction());
        registerAxisFunciton(new FollowingSiblingFunction());
        registerAxisFunciton(new FollowingSiblingOneFunction());
        registerAxisFunciton(new ParentFunction());
        registerAxisFunciton(new PrecedingSiblingFunction());
        registerAxisFunciton(new Superappium.xpath.function.axis.SelfFunction());
        registerAxisFunciton(new SiblingFunction());
    }


}
