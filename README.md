# Connect Messenger

Telegram-inspired website preview and Android companion starter.

Included: responsive web UI, native Java APK project, manually enabled AccessibilityService, Android MediaProjection system-consent flow, foreground notification, and GitHub Actions build workflow.

Limitations: web chat is local-only; account authentication, persistent messages, device pairing, WebSocket signaling, and live WebRTC screen streaming require a hosted backend and TURN infrastructure. The APK does not silently capture or transmit screen data.

Build: upload this folder and `.github/workflows/connect-messenger-apk.yml` to your GitHub repository, then run Actions → Build Connect Messenger APK. Download artifact `connect-messenger-debug-apk`.