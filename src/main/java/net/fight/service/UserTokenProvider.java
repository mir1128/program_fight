package net.fight.service;

import net.fight.helper.FightCookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class UserTokenProvider {
    static final String FIGHT_TOKEN = "_token";

    Cookie toCookie() {
        return null;
    }

    FightCookie getP2PCookie(HttpServletRequest request) {
        return null;
    }
}
