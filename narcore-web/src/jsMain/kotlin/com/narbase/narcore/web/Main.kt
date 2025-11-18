package com.narbase.narcore.web

import com.narbase.kunafa.core.components.Page
import com.narbase.kunafa.core.components.View
import com.narbase.kunafa.core.components.page
import com.narbase.kunafa.core.components.view
import com.narbase.kunafa.core.css.height
import com.narbase.kunafa.core.css.overflow
import com.narbase.kunafa.core.css.width
import com.narbase.kunafa.core.dimensions.px
import com.narbase.kunafa.core.dimensions.vh
import com.narbase.kunafa.core.dimensions.vw
import com.narbase.narcore.web.common.models.Direction
import com.narbase.narcore.web.events.EscapeClickedEvent
import com.narbase.narcore.web.framework7.setupFramework7AppIndex
import com.narbase.narcore.web.login.LoginPageContent
import com.narbase.narcore.web.login.LoginViewController
import com.narbase.narcore.web.storage.StorageManager
import com.narbase.narcore.web.utils.eventbus.EventBus
import com.narbase.narcore.web.utils.views.PopUpDialog
import com.narbase.narcore.web.utils.views.SnackBar
import com.narbase.narcore.web.utils.views.customViews.initWarningPopupDialog
import kotlinx.browser.document
import org.w3c.dom.events.KeyboardEvent

/*
 * Copyright 2017-2020 Narbase technologies and contributors. Use of this source code is governed by the MIT License.
 */


fun main() {
//    Routing.init()
    requireAssetsForWebpack()
//    Main().setup()
    setupFramework7AppIndex()
}


class Main {

    fun setup() {

        page {
            Page.title = "Narcore"
            Page.useRtl = (StorageManager.language.direction == Direction.RTL)

            style {
                overflow = "hidden"
                width = 100.vw
                height = 100.vh
            }

            PopUpDialog.popUpRootView = view {
                style {
                    width = 0.px
                    height = 0.px
                }
            }

            initWarningPopupDialog()
            setupEventListeners()
            SnackBar.setup()
            mountApp()
        }
    }

    private fun setupEventListeners() {
        document.addEventListener("onkeydown", { evt ->
            evt as KeyboardEvent
            val isEscape = if (evt.key != undefined) {
                (evt.key == "Escape" || evt.key == "Esc")
            } else (evt.keyCode == 27)

            if (isEscape) {
                EventBus.publish(EscapeClickedEvent())
            }
            Unit
        })
    }

    private fun View.mountApp() {
        val appViewController = AppViewController()
        val loginPage = LoginPageContent(LoginViewController(appViewController))

        mount(AppComponent(appViewController, loginPage))

    }
}


private fun requireAssetsForWebpack() {
    js("require('material-design-icons-iconfont/dist/material-design-icons.css')")
    js("require('typeface-open-sans')")
    js("require('tippy.js/index.css')")
    js("require('tippy.js/themes/light-border.css')")
    js("require('pikaday/css/pikaday.css')")
    js("require('flatpickr/dist/flatpickr.min.css')")

}


/*
fun setupFramework7Shell() {
    // Kunafa root inside AppComponent
    val appView = document.getElementById("appView") as? HTMLElement ?: return

    // --- Build Framework7 DOM like in their HTML example ---

    val appRoot = document.createElement("div") as HTMLElement
    appRoot.id = "app"
    appRoot.className = "app"

    val mainView = document.createElement("div") as HTMLElement
    mainView.className = "view view-main"

    val page = document.createElement("div") as HTMLElement
    page.className = "page"
    page.setAttribute("data-name", "home")

    // Navbar
    val navbar = document.createElement("div") as HTMLElement
    navbar.className = "navbar"

    val navbarBg = document.createElement("div") as HTMLElement
    navbarBg.className = "navbar-bg"

    val navbarInner = document.createElement("div") as HTMLElement
    navbarInner.className = "navbar-inner"

    val title = document.createElement("div") as HTMLElement
    title.className = "title"
    title.textContent = "Narcore" // or "Narcore"

    navbarInner.appendChild(title)
    navbar.appendChild(navbarBg)
    navbar.appendChild(navbarInner)

    // Toolbar
    val toolbar = document.createElement("div") as HTMLElement
    toolbar.className = "toolbar toolbar-bottom"

    val toolbarInner = document.createElement("div") as HTMLElement
    toolbarInner.className = "toolbar-inner"

    fun toolbarLink(text: String): HTMLElement {
        val a = document.createElement("a") as HTMLElement
        a.className = "link"
        a.textContent = text
        a.setAttribute("href", "#")
        return a
    }

    toolbarInner.appendChild(toolbarLink("Link 1"))
    toolbarInner.appendChild(toolbarLink("Link 2"))
    toolbar.appendChild(toolbarInner)

    // Page content container – Framework7's scrollable content
    val pageContent = document.createElement("div") as HTMLElement
    pageContent.className = "page-content"

    // --- Move Kunafa appView into Framework7 page-content ---
    appView.parentNode?.removeChild(appView)
    pageContent.appendChild(appView)

    // Assemble the page
    page.appendChild(navbar)
    page.appendChild(toolbar)
    page.appendChild(pageContent)

    mainView.appendChild(page)
    appRoot.appendChild(mainView)

    // Attach Framework7 root to body
    document.body!!.appendChild(appRoot)

    // --- Init Framework7 on #app ---

    val params = objectOf<dynamic> {
        el = "#app"
        name = "Narcore-Kunafa"
        panel = objectOf<dynamic> {
            swipe = true
        }
        routes = arrayOf<dynamic>(
            objectOf<dynamic> {
                path = "/"
                url = "./index.html"
            },
            objectOf<dynamic> {
                path = "/about/"
                url = "./about.html"
            },
            // 404 – must be last
            objectOf<dynamic> {
                path = "(.*)"
                url = "./404.html"
            }
        )
    }

    val app = Framework7(params).asDynamic()
    app.views.create(".view-main")
}*/
