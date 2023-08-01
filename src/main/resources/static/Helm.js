/**
 * not used in current code
 */
function getSelectors() {
    console.clear()
    var data = document.getElementById("select")

    var json = "[\n"

    var perv_len = 1

    var perv_parent = 0


    let curr_head = [1, 0, 0, 0]


    for (let i = 0; i < data.length; i++) {
        let optionText = data.options[i].text;
        let optionValues = data.options[i].value;

        optionText = optionText.split(/\s{4}/);

        var len = optionText.length;

        if (perv_len !== len) {
            perv_len = len
        }
        curr_head[len - 1] = optionValues

        if (len === 1) {
            perv_parent = 0
        } else
            perv_parent = curr_head[len - 2]


        json += "{ \n " +
            "\"id\":\"" + optionValues + "\", \n " +
            "\"parent\":\"" + perv_parent + "\", \n " +
            "\"name\":\"" + optionText[len - 1] + "\", \n " +
            "\"level\":\"" + len + "\" \n " +
            "},\n"


    }
    json += "\n]"
    console.log(json);
}