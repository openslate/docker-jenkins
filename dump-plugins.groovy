// Run this script on Jenkins to output the list of plugins used in the Helm chart answers

// Before running this snippet, update all the plugins
// Here's some JavaScript to click all plugins in Update Center from the browser console:
// document.querySelectorAll('input[type=checkbox]').forEach(function(i) {i.click()})

Jenkins.instance.pluginManager.plugins.toSorted({a, b -> a.getShortName() <=> b.getShortName()}).each{
 plugin ->
   println ("${plugin.getShortName()}:${plugin.getVersion()}")
}
