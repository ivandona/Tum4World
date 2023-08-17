function openCookieWindow() {
    //Check if window has been opened before
    if(!localStorage.getItem("firstVisit")) {
        // Specify the width, height, and position for the new window
        var width = 300;
        var height = 200;
        var right = 10;
        var bottom = 10;

        // Construct the window features
        var windowFeatures = `
                width=${width},
                height=${height},
                right=${right},
                bottom=${bottom},
                location=no,
                menubar=no,
                resizable=no,
                scrollbars=no,
                status=no,
                toolbar=no
            `;

        //Open the window
        var cookieWindow = window.open("pageControllerServlet?page=info-cookie", "Cookie Window", windowFeatures);

        localStorage.setItem("firstVisit", "true");
    }
}