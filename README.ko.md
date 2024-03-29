# caramelProtocolAPI 
> Fake ViaVersion API

[![라이선스](https://img.shields.io/github/license/LemonCaramel/caramelProtocolAPI)](https://github.com/LemonCaramel/caramelProtocolAPI/blob/master/LICENSE)
[![마지막 릴리즈](https://img.shields.io/github/v/release/LemonCaramel/caramelProtocolAPI)](https://caramel.moe/)
[![이슈](https://img.shields.io/github/issues/LemonCaramel/caramelProtocolAPI)](https://github.com/LemonCaramel/caramelProtocolAPI/issues)
[![빌드 상태](https://travis-ci.com/LemonCaramel/caramelProtocolAPI.svg?branch=master)](https://travis-ci.com/LemonCaramel/caramelProtocolAPI)
[![CodeFactor](https://www.codefactor.io/repository/github/lemoncaramel/caramelprotocolapi/badge/master)](https://www.codefactor.io/repository/github/lemoncaramel/caramelprotocolapi/overview/master)
[![Discord](https://img.shields.io/badge/use%20server-%20discord-blue.svg)](https://discord.gg/f9qGtYF)

*다른 언어로 읽기: [English](README.md), [한국어](README.ko.md).*

--------


소개
--------
 - **주의!** 이 플러그인은 Daydream(Server Software)가 사용되는 서버에서만 정상적인 작동을 보장합니다.
 - 이 플러그인은 버전 간의 호환성 문제 *(ex. 안티 치트)* 를 해결하는 Fake API 플러그인입니다.

구조
--------
 - **1.** 플레이어가 프록시(Bungeecord, Velocity)를 통해 마인크래프트 서버에 접속합니다.
 - **2.** 프록시 서버는 플레이어의 프로토콜 버전을 마인크래프트 서버로 보냅니다.
 - **3.** 정보를 전달 받은 Daydream(서버 소프트웨어)은 NMS player connection 클래스의 프로토콜 버전 필드를 변경합니다.
 - **4.** 이제 이 플러그인은 ViaVersion을 대신해 올바른 프로토콜 버전을 반환합니다.

출처
--------
 - **[ViaVersion](https://github.com/ViaVersion/ViaVersion)** (이 API 플러그인의 원본 플러그인 입니다)
    - [us.myles.ViaVersion.api](https://github.com/ViaVersion/ViaVersion/blob/master/common/src/main/java/us/myles/ViaVersion/api) 패키지의 일부 클래스가 사용되었습니다.
    - [com.viaversion.viaversion.api](https://github.com/ViaVersion/ViaVersion/blob/master/common/src/main/java/com/viaversion/viaversion/api) 패키지의 일부 클래스가 사용되었습니다.

----------

라이선스
--------
 - MIT License를 사용하며, 자세한 사항은 [LICENSE](https://github.com/LemonCaramel/caramelProtocolAPI/blob/master/LICENSE) 를 참조해주세요.
