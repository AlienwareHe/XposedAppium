package Superappium.xpath.parser.expression.token.consumer;

import Superappium.xpath.parser.TokenQueue;
import Superappium.xpath.parser.expression.token.TokenConsumer;

public class XpathConsumer implements TokenConsumer {
    public String consume(TokenQueue tokenQueue) {
        if (tokenQueue.matches("`")) {
            return tokenQueue.chompBalanced('`', '`');
        }
        return null;
    }

    public int order() {
        return 20;
    }

    public String tokenType() {
        return "XPATH";
    }
}
