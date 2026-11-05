package com.connectmessenger.companion;
import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
/** Permission-gated assistance service; this starter does not collect screen content. */
public class ConnectAccessibilityService extends AccessibilityService {
 @Override public void onAccessibilityEvent(AccessibilityEvent event) {}
 @Override public void onInterrupt() {}
}
