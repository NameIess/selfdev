package util;

import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.util.fileloader.XlsDataFileLoader;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

public class ServiceTestExecutionListener implements TestExecutionListener {
    private static final String EMPTY_STRING = "";
    private static final String DATABASE_TESTER_BEAN = "databaseTester";
    private static final String XLS_FILE_LOADER = "xlsDataFileLoader";
    private IDatabaseTester databaseTester;

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {

    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        if (databaseTester != null) {
            databaseTester.onTearDown();
        }
    }

    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {

    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        DataSets dataSetAnnotation = testContext.getTestMethod().getAnnotation(DataSets.class);

        if (dataSetAnnotation == null) {
            return;
        }

        String dataSetName = dataSetAnnotation.setUpDataSet();
        if (!dataSetName.equals(EMPTY_STRING)) {
            databaseTester = (IDatabaseTester) testContext.getApplicationContext().getBean(DATABASE_TESTER_BEAN);
            XlsDataFileLoader xlsDataFileLoader = (XlsDataFileLoader) testContext.getApplicationContext().getBean(XLS_FILE_LOADER);
            IDataSet dataSet = xlsDataFileLoader.load(dataSetName);
            databaseTester.setDataSet(dataSet);
            databaseTester.onSetup();
        }
    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {

    }
}
