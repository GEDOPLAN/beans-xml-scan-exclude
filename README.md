# beans-xml-scan-exclude

Test case for conditional exclusion of beans in bean discovery in Apache OpenWebBeans.

The descriptor beans.xml offers conditional exclusion of beans. With the descriptor included in this project,

* de.gedoplan.issues.beansxmlscanexclude.BeanA should be resolvable, because it is not mentioned in the descriptor,
* de.gedoplan.issues.beansxmlscanexclude.BeanB should be unsatisfied, because it is excluded in the descriptor,
* de.gedoplan.issues.beansxmlscanexclude.BeanC should be resolvable, because the exclusion element in the descriptor references a non-existing system property,
* de.gedoplan.issues.beansxmlscanexclude.BeanD should be unsatisfied, because the exclusion element in the descriptor references a existing system property.

OWB erroneously excludes BeanC.
To reproduce run de.gedoplan.issues.beansxmlscanexclude.ExcludeTest as JUnit test. 

This applies to OWB 2.0.7.

For comparison the maven profile cdi-weld may be activated to use Weld instead of OWB. Weld handles the exclusions as expected.