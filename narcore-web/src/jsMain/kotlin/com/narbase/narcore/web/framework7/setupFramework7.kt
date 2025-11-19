package com.narbase.narcore.web.framework7

import com.narbase.kunafa.core.components.Component
import com.narbase.kunafa.core.components.View
import com.narbase.kunafa.core.components.page
import com.narbase.kunafa.core.components.textView
import com.narbase.kunafa.core.components.*
import com.narbase.kunafa.core.css.*
import com.narbase.kunafa.core.dimensions.*
import com.narbase.kunafa.core.routing.link
import com.narbase.narcore.web.common.models.Direction
import com.narbase.narcore.web.storage.StorageManager
import external.framework7.F7Route
import external.framework7.Framework7
import external.framework7.component1
import external.framework7.component2
import external.framework7.component3
import external.framework7.component4
import external.framework7.component5
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.Event

data class KunafaRoute(
    val rootElementId: String,
    val componentFactory: () -> Component
)

private val kunafaRouteConfigurationMap = mapOf(
    "/about/".removeSuffix("/") to KunafaRoute(
        "kunafa-about-root",
        { AboutComponent() }
    ),
    "/form/".removeSuffix("/") to KunafaRoute(
        "kunafa-form-root",
        { FormComponent() }
    ),
    "(.*)" to KunafaRoute(
        "kunafa-not-found-root",
        { NotFoundComponent() }
    )
)

fun setupFramework7AppIndex() {
    js("require('framework7/css/bundle')")

    page {
        Page.title = "Narcore-Kunafa"
        Page.useRtl = (StorageManager.language.direction == Direction.RTL)
        head {
            link("/manifest.json") {
                element.rel = "manifest"
            }
        }
        style {
            overflow = "hidden"
            width = 100.vw
            height = 100.vh
        }

        view {
            id = "app"
            element.className = "app"

            view {
                element.className = "panel panel-left panel-cover dark panel-init"
                view {
                    element.className = "view"
                    view {
                        element.className = "page"
                        view {
                            element.className = "navbar"
                            view { element.className = "navbar-bg" }
                            view {
                                element.className = "navbar-inner"
                                view {
                                    element.className = "title"
                                    textView { text = "Left Panel" }
                                }
                            }
                        }
                        view {
                            element.className = "page-content"
                            view {
                                element.className = "block"
                                textView { text = "Left panel content goes here" }
                            }
                        }
                    }
                }
            }

            view {
                element.className = "panel panel-right panel-reveal dark"
                view {
                    element.className = "view"
                    view {
                        element.className = "page"
                        view {
                            element.className = "navbar"
                            view { element.className = "navbar-bg" }
                            view {
                                element.className = "navbar-inner"
                                view {
                                    element.className = "title"
                                    textView { text = "Right Panel" }
                                }
                            }
                        }
                        view {
                            element.className = "page-content"
                            view {
                                element.className = "block"
                                textView { text = "Right panel content goes here" }
                            }
                        }
                    }
                }
            }

            view {
                element.className = "view view-main view-init safe-areas"

                view {
                    element.className = "page"
                    element.setAttribute("data-name", "home")

                    view {
                        element.className = "navbar navbar-large"
                        view { element.className = "navbar-bg" }
                        view {
                            element.className = "navbar-inner"

                            view {
                                element.className = "left"
                                a {
                                    href = "#"
                                    element.className = "link icon-only panel-open"
                                    element.setAttribute("data-panel", "left")

                                    view {
                                        element.innerHTML =
                                            """<i class="icon f7-icons if-not-md">menu</i>
                                               <i class="icon material-icons if-md">menu</i>"""
                                                .trimIndent()
                                    }
                                }
                            }

                            view {
                                element.className = "title sliding"
                                textView { text = "Narcore-Kunafa" }
                            }

                            view {
                                element.className = "right"
                                a {
                                    href = "#"
                                    element.className = "link icon-only panel-open"
                                    element.setAttribute("data-panel", "right")
                                    view {
                                        element.innerHTML =
                                            """<i class="icon f7-icons if-not-md">menu</i>
                                               <i class="icon material-icons if-md">menu</i>"""
                                                .trimIndent()
                                    }
                                }
                            }

                            view {
                                element.className = "title-large"
                                view {
                                    element.className = "title-large-text"
                                    textView { text = "Narcore-Kunafa" }
                                }
                            }
                        }
                    }

                    view {
                        element.className = "toolbar toolbar-bottom"
                        view {
                            element.className = "toolbar-inner"
                            a {
                                href = "#"
                                element.className = "link"
                                textView { text = "Left Link" }
                            }
                            a {
                                href = "#"
                                element.className = "link"
                                textView { text = "Right Link" }
                            }
                        }
                    }

                    view {
                        element.className = "page-content"

                        view {
                            element.className = "block"
                            textView {
                                text = "Here is your blank Framework7 app. Let's see what we have here."
                            }
                        }

                        view {
                            element.className = "block-title"
                            textView { text = "Navigation" }
                        }

                        view {
                            element.className = "list list-strong inset list-dividers-ios"
                            ul {
                                a {
                                    href = "/about/"
                                    element.className = "item-content item-link"
                                    view {
                                        element.className = "item-inner"
                                        view {
                                            element.className = "item-title"
                                            textView { text = "About" }
                                        }
                                    }
                                }

                                a {
                                    href = "/form/"
                                    element.className = "item-content item-link"
                                    view {
                                        element.className = "item-inner"
                                        view {
                                            element.className = "item-title"
                                            textView { text = "Form" }
                                        }
                                    }
                                }
                            }
                        }

                        view {
                            element.className = "block-title"
                            textView { text = "Modals" }
                        }

                        view {
                            element.className = "block grid grid-cols-2 grid-gap"

                            a {
                                href = "#"
                                element.className = "button button-fill popup-open"
                                element.setAttribute("data-popup", "#my-popup")
                                textView { text = "Popup" }
                            }

                            a {
                                href = "#"
                                element.className = "button button-fill login-screen-open"
                                element.setAttribute("data-login-screen", "#my-login-screen")
                                textView { text = "Login Screen" }
                            }

                            a {
                                href = "#"
                                element.className = "button button-fill sheet-open"
                                element.setAttribute("data-sheet", "#bottom-sheet-draggable")
                                textView { text = "Draggable Sheet" }
                            }

                            a {
                                href = "#"
                                element.className = "button button-fill sheet-open"
                                element.setAttribute("data-sheet", "#bottom-sheet-full")
                                textView { text = "Full Sheet" }
                            }
                        }

                        view {
                            element.className = "block-title"
                            textView { text = "Panels" }
                        }

                        view {
                            element.className = "block grid grid-cols-2 grid-gap"
                            a {
                                href = "#"
                                element.className = "button button-fill panel-open"
                                element.setAttribute("data-panel", "left")
                                textView { text = "Left Panel" }
                            }
                            a {
                                href = "#"
                                element.className = "button button-fill panel-open"
                                element.setAttribute("data-panel", "right")
                                textView { text = "Right Panel" }
                            }
                        }

                        view {
                            element.className = "list list-strong inset list-dividers-ios links-list"
                            ul {
                                a {
                                    href = "/dynamic-route/blog/45/post/125/?foo=bar#about"
                                    textView { text = "Dynamic (Component) Route" }
                                }
                                a {
                                    href = "/load-something-that-doesnt-exist/"
                                    textView { text = "Default Route (404)" }
                                }
                                a {
                                    href = "/request-and-load/user/123456/"
                                    textView { text = "Request Data & Load" }
                                }
                            }
                        }
                    }
                }
            }

            view {
                id = "my-popup"
                element.className = "popup"
                view {
                    element.className = "view"
                    view {
                        element.className = "page"
                        view {
                            element.className = "navbar"
                            view { element.className = "navbar-bg" }
                            view {
                                element.className = "navbar-inner"
                                view {
                                    element.className = "title"
                                    textView { text = "Popup" }
                                }
                                view {
                                    element.className = "right"
                                    a {
                                        href = "#"
                                        element.className = "link popup-close"
                                        textView { text = "Close" }
                                    }
                                }
                            }
                        }
                        view {
                            element.className = "page-content"
                            view {
                                element.className = "block"
                                textView { text = "Popup content goes here." }
                            }
                        }
                    }
                }
            }

            view {
                id = "my-login-screen"
                element.className = "login-screen"
                view {
                    element.className = "view"
                    view {
                        element.className = "page"
                        view {
                            element.className = "page-content login-screen-content"

                            view {
                                element.className = "login-screen-title"
                                textView { text = "Login" }
                            }

                            view {
                                element.className = "list"
                                ul {
                                    view {
                                        element.className = "item-content item-input"
                                        view {
                                            element.className = "item-inner"
                                            view {
                                                element.className = "item-title item-label"
                                                textView { text = "Username" }
                                            }
                                            view {
                                                element.className = "item-input-wrap"
                                                input {
                                                    element.setAttribute("type", "text")
                                                    element.setAttribute("name", "username")
                                                    element.setAttribute("placeholder", "Your username")
                                                }
                                            }
                                        }
                                    }

                                    view {
                                        element.className = "item-content item-input"
                                        view {
                                            element.className = "item-inner"
                                            view {
                                                element.className = "item-title item-label"
                                                textView { text = "Password" }
                                            }
                                            view {
                                                element.className = "item-input-wrap"
                                                input {
                                                    element.setAttribute("type", "password")
                                                    element.setAttribute("name", "password")
                                                    element.setAttribute("placeholder", "Your password")
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            view {
                                element.className = "list"
                                ul {
                                    view {
                                        element.className = "item-content"
                                        a {
                                            href = "#"
                                            element.className = "item-link list-button login-button"
                                            textView { text = "Sign In" }
                                            onClick = {
                                                Framework7Navigation.framework7AppInstance.loginScreen.close("#my-login-screen")
                                                Framework7Navigation.framework7AppInstance.dialog.alert("hello world?")
                                            }
                                        }
                                    }
                                }
                                view {
                                    element.className = "block-footer"
                                    textView {
                                        text =
                                            "Some text about login information.\nClick \"Sign In\" to close Login Screen"
                                    }
                                }
                            }
                        }
                    }
                }
            }
            view {
                id = "bottom-sheet-draggable"
                element.className = "sheet-modal"
                element.setAttribute("style", "height:auto")
                element.setAttribute("data-swipe-to-close", "true")
                element.setAttribute("data-swipe-to-step", "true")
                element.setAttribute("data-backdrop", "true")
//                element.setAttribute("data-push", "true")

                view {
                    element.className = "sheet-modal-inner"


                    view {
                        element.className = "swipe-handler"
                    }

                    view {
                        element.className = "sheet-modal-swipe-step"
                        view {
                            element.className = "block"
                            textView { text = "Swipe up for more details" }
                        }
                    }


                    view {
                        element.className = "page-content"
                        view {
                            element.className = "block"
                            textView { text = "More draggable bottom sheet content..." }
                        }
                    }
                }
            }
            view {
                id = "bottom-sheet-full"
                element.className = "sheet-modal"
                view {
                    element.className = "toolbar"
                    view {
                        element.className = "toolbar-inner"
                        view {
                            element.className = "left"
                            textView { text = "Full Sheet" }
                        }
                        view {
                            element.className = "right"
                            a {
                                href = "#"
                                element.className = "link sheet-close"
                                textView { text = "Close" }
                            }
                        }
                    }
                }
                view {
                    element.className = "sheet-modal-inner"
                    view {
                        element.className = "page-content"
                        view {
                            element.className = "block"
                            textView { text = "Full sheet content. Opens to its content height." }
                        }
                    }
                }
            }
        }

        setupPageInitKunafaMounts()
    }

    val framework7Routes = arrayOf<F7Route>(
        objectOf {
            path = "/"
            pageName = "home"
        },

        objectOf {
            path = "/about"
            alias = arrayOf("/about/")
            content = """
                <div class="page" data-name="about">
                  <div class="page-content">
                    <div id="kunafa-about-root" class="kunafa-page-root"></div>
                  </div>
                </div>
            """.trimIndent()
        },

        objectOf {
            path = "/form"
            alias = arrayOf("/form/")
            content = """
                <div class="page" data-name="form">
                  <div class="page-content">
                    <div id="kunafa-form-root" class="kunafa-page-root"></div>
                  </div>
                </div>
            """.trimIndent()
        },

        objectOf {
            path = "/dynamic-route/blog/:blogId/post/:postId/"
            async = { (framework7Router, targetRoute, previousRoute, resolveRoute, rejectRoute) ->
                val dynamicRouteUrl = targetRoute.url ?: ""
                val dynamicRoutePath = targetRoute.path ?: ""
                val dynamicRouteParameters = targetRoute.params
                val dynamicRouteQuery = targetRoute.query
                val dynamicRouteHash = targetRoute.hash?.toString().orEmpty()

                val blogIdentifier = dynamicRouteParameters.blogId?.toString().orEmpty()
                val postIdentifier = dynamicRouteParameters.postId?.toString().orEmpty()

                val dynamicRouteShellPageHtml = """
                    <div class="page" data-name="dynamic-route">
                      <div class="page-content">
                        <div id="kunafa-dynamic-route-root" class="kunafa-page-root"></div>
                      </div>
                    </div>
                """.trimIndent()

                resolveRoute(
                    objectOf<dynamic> {
                        this.content = dynamicRouteShellPageHtml
                    },
                    null
                )

                window.setTimeout({
                    val dynamicRouteKunafaRootElement =
                        document.getElementById("kunafa-dynamic-route-root") as HTMLElement?
                            ?: return@setTimeout

                    val dynamicRouteKunafaRootView = View(null, dynamicRouteKunafaRootElement)
                    dynamicRouteKunafaRootView.mount(
                        DynamicRouteComponent(
                            dynamicRouteUrl = dynamicRouteUrl,
                            dynamicRoutePath = dynamicRoutePath,
                            dynamicRouteParametersJsonString = JSON.stringify(dynamicRouteParameters),
                            dynamicRouteQueryJsonString = JSON.stringify(dynamicRouteQuery),
                            dynamicRouteHash = dynamicRouteHash,
                            blogIdentifier = blogIdentifier,
                            postIdentifier = postIdentifier
                        )
                    )
                }, 0)
            }
        },

        objectOf {
            path = "/request-and-load/user/:userId/"
            async = { (framework7Router, targetRoute, previousRoute, resolveRoute, rejectRoute) ->

                val framework7AppInstance = framework7Router.app
                val userIdentifier = targetRoute.params.userId

                framework7AppInstance.preloader.show()

                window.setTimeout({
                    val loadedUser = objectOf<dynamic> {
                        firstName = "Vladimir"
                        lastName = "Kharlampidi"
                        about = "Hello, I am creator of Framework7! Hope you like it!"
                        links = arrayOf(
                            objectOf<dynamic> {
                                title = "Framework7 Website"
                                url = "https://framework7.io"
                            },
                            objectOf<dynamic> {
                                title = "Framework7 Forum"
                                url = "https://forum.framework7.io"
                            }
                        )
                    }

                    framework7AppInstance.preloader.hide()

                    val userLinksArray = loadedUser.links.unsafeCast<Array<dynamic>>()
                    val userLinksListHtml = userLinksArray.joinToString(separator = "") { link ->
                        """<li><a class="external" target="_blank" href="${link.url}">${link.title}</a></li>"""
                    }

                    val userDetailsPageHtml = """
                        <div class="page">
                          <div class="navbar">
                            <div class="navbar-bg"></div>
                            <div class="navbar-inner sliding">
                              <div class="left">
                                <a href="#" class="back link">
                                  <i class="icon icon-back"></i>
                                  <span class="if-not-md">Back</span>
                                </a>
                              </div>
                              <div class="title">${loadedUser.firstName} ${loadedUser.lastName}</div>
                            </div>
                          </div>
                          <div class="page-content">
                            <div class="block block-strong inset">
                              ${loadedUser.about}
                            </div>
                            <div class="list list-strong inset list-dividers-ios links-list">
                              <ul>
                                $userLinksListHtml
                              </ul>
                            </div>
                            <div class="block block-strong inset">
                              <p>User ID from route: <b>$userIdentifier</b></p>
                            </div>
                          </div>
                        </div>
                    """.trimIndent()

                    resolveRoute(
                        objectOf<dynamic> {
                            this.content = userDetailsPageHtml
                        },
                        null
                    )
                }, 1000)
            }
        },

        objectOf {
            path = "(.*)"
            content = """
                <div class="page" data-name="not-found">
                  <div class="page-content">
                    <div id="kunafa-not-found-root" class="kunafa-page-root"></div>
                  </div>
                </div>
            """.trimIndent()
        }
    )

    val framework7InitializationParameters = objectOf<dynamic> {
        el = "#app"
        name = "Narcore-Kunafa"
        this.routes = framework7Routes
    }

    val framework7AppInstance = Framework7(framework7InitializationParameters).asDynamic()
    val mainFramework7View = framework7AppInstance.views.create(".view-main", objectOf<dynamic> {
        main = true
        animate = true
        url = "/"
    })

    Framework7Navigation.framework7AppInstance = framework7AppInstance
    Framework7Navigation.mainFramework7View = mainFramework7View
}

object Framework7Navigation {
    var framework7AppInstance: dynamic = null
    var mainFramework7View: dynamic = null
}

fun View.setupPageInitKunafaMounts() {
    val pageLifecycleEventHandler: (Event) -> Unit = handler@{ domEvent ->
        val framework7PageDetail = domEvent.asDynamic().detail ?: return@handler
        val framework7Route = framework7PageDetail.route
        val framework7RoutePath = framework7Route?.path as String? ?: return@handler

        val matchedKunafaRouteConfiguration =
            kunafaRouteConfigurationMap[framework7RoutePath.removeSuffix("/")]
                ?: kunafaRouteConfigurationMap["(.*)"]
                ?: return@handler

        val kunafaRootElement =
            document.getElementById(matchedKunafaRouteConfiguration.rootElementId) as HTMLElement?
        if (kunafaRootElement != null) {
            val kunafaRootView = View(this, kunafaRootElement)
            kunafaRootView.mount(matchedKunafaRouteConfiguration.componentFactory())
        }
    }

    document.addEventListener("page:init", pageLifecycleEventHandler)
    document.addEventListener("page:reinit", pageLifecycleEventHandler)
}

class AboutComponent : Component() {
    override fun View?.getView(): View {
        return view {
            element.className = "page"
            element.setAttribute("data-name", "about")

            view {
                element.className = "navbar"
                view { element.className = "navbar-bg" }
                view {
                    element.className = "navbar-inner sliding"

                    view {
                        element.className = "left"
                        a {
                            href = "#"
                            element.className = "link back"
                            view {
                                element.innerHTML = """
                                    <i class="icon icon-back"></i>
                                    <span class="if-not-md">Back</span>
                                """.trimIndent()
                            }
                        }
                    }

                    view {
                        element.className = "title"
                        textView { text = "About" }
                    }
                }
            }

            view {
                element.className = "page-content"

                view {
                    element.className = "block-title"
                    textView { text = "About My App" }
                }
                verticalLayout {
                    element.className = "block"
                    textView {
                        text = """
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                            Magni molestiae laudantium dignissimos est nobis delectus nemo
                            ea alias voluptatum architecto, amet similique, saepe iste
                            consectetur in repellat ut minus quibusdam!
                        """.trimIndent()
                    }
                    textView {
                        text = """
                            Molestias et distinctio porro nesciunt ratione similique,
                            magni doloribus, rerum nobis, aliquam quae reiciendis quasi
                            modi. Nam a recusandae, fugiat in ea voluptates fuga eius,
                            velit corrupti reprehenderit dignissimos consequatur!
                        """.trimIndent()
                    }
                    textView {
                        text = """
                            Blanditiis, cumque quo adipisci. Molestiae, dolores dolorum
                            quos doloremque ipsa ullam eligendi commodi deserunt
                            doloribus inventore magni? Ea mollitia veniam nostrum nihil,
                            iusto doloribus a at! Ea molestiae ullam delectus!
                        """.trimIndent()
                    }
                }
            }
        }
    }
}

class NotFoundComponent : Component() {
    override fun View?.getView(): View {
        return view {
            element.className = "page"
            element.setAttribute("data-name", "not-found")

            view {
                element.className = "navbar"
                view { element.className = "navbar-bg" }
                view {
                    element.className = "navbar-inner sliding"
                    view {
                        element.className = "left"
                        a {
                            href = "#"
                            element.className = "link back"
                            view {
                                element.innerHTML = """
                                    <i class="icon icon-back"></i>
                                    <span class="if-not-md">Back</span>
                                """.trimIndent()
                            }
                        }
                    }
                    view {
                        element.className = "title"
                        textView { text = "Not found" }
                    }
                }
            }

            view {
                element.className = "page-content"
                verticalLayout {
                    element.className = "block block-strong inset"
                    textView { text = "Sorry" }
                    textView { text = "Requested content not found." }
                }
            }
        }
    }
}

class FormComponent : Component() {
    override fun View?.getView(): View {
        return view {
            element.className = "page"
            element.setAttribute("data-name", "form")

            view {
                element.className = "navbar"
                view { element.className = "navbar-bg" }
                view {
                    element.className = "navbar-inner sliding"
                    view {
                        element.className = "left"
                        a {
                            href = "#"
                            element.className = "link back"
                            view {
                                element.innerHTML = """
                                    <i class="icon icon-back"></i>
                                    <span class="if-not-md">Back</span>
                                """.trimIndent()
                            }
                        }
                    }
                    view {
                        element.className = "title"
                        textView { text = "Form" }
                    }
                }
            }

            view {
                element.className = "page-content"

                view {
                    element.className = "block-title"
                    textView { text = "Form Example" }
                }

                view {
                    element.className = "list list-strong-ios list-dividers-ios list-outline-ios"
                    ul {
                        view {
                            element.className = "item-content item-input"
                            view {
                                element.className = "item-inner"
                                view {
                                    element.className = "item-title item-label"
                                    textView { text = "Name" }
                                }
                                view {
                                    element.className = "item-input-wrap"
                                    input {
                                        element.setAttribute("type", "text")
                                        element.setAttribute("placeholder", "Your name")
                                    }
                                }
                            }
                        }

                        view {
                            element.className = "item-content item-input"
                            view {
                                element.className = "item-inner"
                                view {
                                    element.className = "item-title item-label"
                                    textView { text = "E-mail" }
                                }
                                view {
                                    element.className = "item-input-wrap"
                                    input {
                                        element.setAttribute("type", "email")
                                        element.setAttribute("placeholder", "E-mail")
                                    }
                                }
                            }
                        }

                        view {
                            element.className = "item-content item-input"
                            view {
                                element.className = "item-inner"
                                view {
                                    element.className = "item-title item-label"
                                    textView { text = "URL" }
                                }
                                view {
                                    element.className = "item-input-wrap"
                                    input {
                                        element.setAttribute("type", "url")
                                        element.setAttribute("placeholder", "URL")
                                    }
                                }
                            }
                        }

                        view {
                            element.className = "item-content item-input"
                            view {
                                element.className = "item-inner"
                                view {
                                    element.className = "item-title item-label"
                                    textView { text = "Password" }
                                }
                                view {
                                    element.className = "item-input-wrap"
                                    input {
                                        element.setAttribute("type", "password")
                                        element.setAttribute("placeholder", "Password")
                                    }
                                }
                            }
                        }

                        view {
                            element.className = "item-content item-input"
                            view {
                                element.className = "item-inner"
                                view {
                                    element.className = "item-title item-label"
                                    textView { text = "Phone" }
                                }
                                view {
                                    element.className = "item-input-wrap"
                                    input {
                                        element.setAttribute("type", "tel")
                                        element.setAttribute("placeholder", "Phone")
                                    }
                                }
                            }
                        }

                        view {
                            element.className = "item-content item-input"
                            view {
                                element.className = "item-inner"
                                view {
                                    element.className = "item-title item-label"
                                    textView { text = "Gender" }
                                }
                                view {
                                    element.className = "item-input-wrap"
                                    view {
                                        element.innerHTML = """
                                            <select>
                                              <option>Male</option>
                                              <option>Female</option>
                                            </select>
                                        """.trimIndent()
                                    }
                                }
                            }
                        }

                        view {
                            element.className = "item-content item-input"
                            view {
                                element.className = "item-inner"
                                view {
                                    element.className = "item-title item-label"
                                    textView { text = "Birth date" }
                                }
                                view {
                                    element.className = "item-input-wrap"
                                    input {
                                        element.setAttribute("type", "date")
                                        element.setAttribute("placeholder", "Birth day")
                                        element.setAttribute("value", "2014-04-30")
                                    }
                                }
                            }
                        }

                        view {
                            element.className = "item-content"
                            view {
                                element.className = "item-inner"
                                view {
                                    element.className = "item-title"
                                    textView { text = "Toggle" }
                                }
                                view {
                                    element.className = "item-after"
                                    label {
                                        element.className = "toggle toggle-init"
                                        input {
                                            element.setAttribute("type", "checkbox")
                                        }
                                        span {
                                            element.className = "toggle-icon"
                                        }
                                    }
                                }
                            }
                        }

                        view {
                            element.className = "item-content item-input"
                            view {
                                element.className = "item-inner"
                                view {
                                    element.className = "item-title item-label"
                                    textView { text = "Slider" }
                                }
                                view {
                                    element.className = "item-input-wrap"
                                    view {
                                        element.className = "range-slider range-slider-init"
                                        element.setAttribute("data-label", "true")
                                        input {
                                            element.setAttribute("type", "range")
                                            element.setAttribute("value", "50")
                                            element.setAttribute("min", "0")
                                            element.setAttribute("max", "100")
                                            element.setAttribute("step", "1")
                                        }
                                    }
                                }
                            }
                        }

                        view {
                            element.className = "item-content item-input align-top"
                            view {
                                element.className = "item-inner"
                                view {
                                    element.className = "item-title item-label"
                                    textView { text = "Textarea" }
                                }
                                view {
                                    element.className = "item-input-wrap"
                                    view {
                                        element.innerHTML =
                                            """<textarea placeholder="Bio"></textarea>""".trimIndent()
                                    }
                                }
                            }
                        }

                        view {
                            element.className = "item-content item-input align-top"
                            view {
                                element.className = "item-inner"
                                view {
                                    element.className = "item-title item-label"
                                    textView { text = "Resizable" }
                                }
                                view {
                                    element.className = "item-input-wrap"
                                    view {
                                        element.innerHTML =
                                            """<textarea placeholder="Bio" class="resizable"></textarea>""".trimIndent()
                                    }
                                }
                            }
                        }
                    }
                }

                view {
                    element.className = "block-title"
                    textView { text = "Buttons" }
                }

                view {
                    element.className = "block block-strong-ios block-outline-ios grid grid-cols-2 grid-gap"

                    fun createFramework7Button(buttonText: String, buttonCssClasses: String) {
                        a {
                            href = "#"
                            element.className = buttonCssClasses
                            textView { text = buttonText }
                        }
                    }

                    createFramework7Button("Button", "button")
                    createFramework7Button("Fill", "button button-fill")
                    createFramework7Button("Raised", "button button-raised")
                    createFramework7Button("Raised Fill", "button button-raised button-fill")
                    createFramework7Button("Round", "button button-round")
                    createFramework7Button("Round Fill", "button button-round button-fill")
                    createFramework7Button("Outline", "button button-outline")
                    createFramework7Button("Outline Round", "button button-round button-outline")
                    createFramework7Button("Small", "button button-small button-outline")
                    createFramework7Button("Small Round", "button button-small button-round button-outline")
                    createFramework7Button("Small", "button button-small button-fill")
                    createFramework7Button("Small Round", "button button-small button-round button-fill")
                    createFramework7Button("Large", "button button-large button-raised")
                    createFramework7Button("Large Fill", "button button-large button-fill button-raised")
                    createFramework7Button("Large Red", "button button-large button-fill button-raised color-red")
                    createFramework7Button("Large Green", "button button-large button-fill button-raised color-green")
                }

                view {
                    element.className = "block-title"
                    textView { text = "Checkbox group" }
                }

                view {
                    element.className = "list list-strong-ios list-outline-ios list-dividers-ios"
                    ul {
                        fun createCheckboxItem(checkboxLabelText: String, checkboxValue: String, isChecked: Boolean) {
                            label {
                                element.className = "item-checkbox item-content"
                                input {
                                    element.setAttribute("type", "checkbox")
                                    element.setAttribute("name", "checkbox")
                                    element.setAttribute("value", checkboxValue)
                                    if (isChecked) {
                                        element.setAttribute("checked", "checked")
                                    }
                                }
                                view {
                                    element.className = "item-checkbox-icon-wrapper"
                                    style { marginRight = 8.px }
                                    element.innerHTML = """<i class="icon icon-checkbox"></i>"""
                                }
                                view {
                                    element.className = "item-inner"
                                    view {
                                        element.className = "item-title"
                                        textView { text = checkboxLabelText }
                                    }
                                }
                            }
                        }

                        createCheckboxItem("Books", "Books", true)
                        createCheckboxItem("Movies", "Movies", false)
                        createCheckboxItem("Food", "Food", false)
                        createCheckboxItem("Drinks", "Drinks", false)
                    }
                }

                view {
                    element.className = "block-title"
                    textView { text = "Radio buttons group" }
                }

                view {
                    element.className = "list list-strong-ios list-outline-ios list-dividers-ios"
                    ul {
                        fun createRadioItem(radioLabelText: String, radioValue: String, isChecked: Boolean) {
                            label {
                                element.className = "item-radio item-content"
                                input {
                                    element.setAttribute("type", "radio")
                                    element.setAttribute("name", "radio")
                                    element.setAttribute("value", radioValue)
                                    if (isChecked) {
                                        element.setAttribute("checked", "checked")
                                    }
                                }
                                view {
                                    element.className = "item-radio-icon-wrapper"
                                    style { marginRight = 8.px }
                                    element.innerHTML = """<i class="icon icon-radio"></i>"""
                                }
                                view {
                                    element.className = "item-inner"
                                    view {
                                        element.className = "item-title"
                                        textView { text = radioLabelText }
                                    }
                                }
                            }
                        }

                        createRadioItem("Books", "Books", true)
                        createRadioItem("Movies", "Movies", false)
                        createRadioItem("Food", "Food", false)
                        createRadioItem("Drinks", "Drinks", false)
                    }
                }
            }
        }
    }
}

class DynamicRouteComponent(
    private val dynamicRouteUrl: String,
    private val dynamicRoutePath: String,
    private val dynamicRouteParametersJsonString: String,
    private val dynamicRouteQueryJsonString: String,
    private val dynamicRouteHash: String,
    private val blogIdentifier: String,
    private val postIdentifier: String
) : Component() {

    override fun View?.getView(): View {
        val personName = "Shalaga"
        val personHeightCentimeters = 199
        val favoriteGamesList = listOf("Basketball", "Chess", "Formula 1")

        return view {
            element.className = "page"

            view {
                element.className = "navbar"
                view { element.className = "navbar-bg" }
                view {
                    element.className = "navbar-inner sliding"

                    view {
                        element.className = "left"
                        a {
                            href = "#"
                            element.className = "link back"
                            view {
                                element.innerHTML = """
                                    <i class="icon icon-back"></i>
                                    <span class="if-not-md">Back</span>
                                """.trimIndent()
                            }
                        }
                    }

                    view {
                        element.className = "title"
                        textView { text = "Component Page" }
                    }
                }
            }

            view {
                element.className = "page-content"

                view {
                    element.className = "block block-strong inset"
                    textView {
                        text = "Component page template is rendered via a dynamic route with content."
                    }
                    textView {
                        text = "Here we simulate the same behavior as your dynamic-route.html component."
                    }
                }

                view {
                    element.className = "block-title"
                    textView { text = "Page Component Data" }
                }
                view {
                    element.className = "block block-strong inset"
                    textView {
                        text = "Hello! My name is $personName. I am $personHeightCentimeters cm."
                    }
                    textView {
                        text = "I like to play:"
                        style {
                            marginTop = 8.px
                            marginBottom = 4.px
                        }
                    }
                    view {
                        element.innerHTML = favoriteGamesList.joinToString(
                            prefix = "<ul>",
                            postfix = "</ul>"
                        ) { "<li>$it</li>" }
                    }
                }

                view {
                    element.className = "block-title"
                    textView { text = "Extended Context" }
                }
                view {
                    element.className = "block block-strong inset"

                    textView { text = "Route parameters and query:" }

                    view {
                        style { marginTop = 8.px }
                        textView {
                            text = "\$f7route (simulated)"
                            style { fontWeight = "bold" }
                        }
                        textView { text = "Contains properties of the current route:" }
                        view {
                            style { marginTop = 4.px }
                            element.innerHTML = """
                                <ul style="padding-left:25px">
                                  <li><b>url</b>: $dynamicRouteUrl</li>
                                  <li><b>path</b>: $dynamicRoutePath</li>
                                  <li><b>params</b>: $dynamicRouteParametersJsonString</li>
                                  <li><b>hash</b>: $dynamicRouteHash</li>
                                  <li><b>query</b>: $dynamicRouteQueryJsonString</li>
                                </ul>
                            """.trimIndent()
                        }
                    }

                    view {
                        style { marginTop = 12.px }
                        textView {
                            text = "Route params (extracted)"
                            style { fontWeight = "bold" }
                        }
                        view {
                            style { marginTop = 4.px }
                            element.innerHTML = """
                                <ul style="padding-left:25px">
                                  <li><b>blogId</b>: $blogIdentifier</li>
                                  <li><b>postId</b>: $postIdentifier</li>
                                </ul>
                            """.trimIndent()
                        }
                    }
                }
            }
        }
    }
}