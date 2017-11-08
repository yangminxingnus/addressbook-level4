package seedu.address.storage;
//@@author yangminxingnus
import java.io.IOException;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.UserPrefs;

/**
 * A class to access UserPrefs stored in the hard disk as a json file
 */
public class JsonAccountsStorage implements UserPrefsStorage {

    private String filePath;

    public JsonAccountsStorage(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getUserPrefsFilePath() {
        return filePath;
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException {
        return readUserPrefs(filePath);
    }

    /**
     * Similar to {@link #readUserPrefs()}
     * @param prefsFilePath location of the data. Cannot be null.
     * @throws DataConversionException if the file format is not as expected.
     */
    public Optional<UserPrefs> readUserPrefs(String prefsFilePath) throws DataConversionException {
        return JsonUtil.readJsonFile(prefsFilePath, UserPrefs.class);
    }

    @Override
    public void saveUserPrefs(UserPrefs userPrefs) throws IOException {
        JsonUtil.saveJsonFile(userPrefs, filePath);
    }

    public Optional<AccountsStorage> readAccountsPrefs() throws DataConversionException, IOException {
        return readAccountsPrefs(filePath);
    }

    public Optional<AccountsStorage> readAccountsPrefs(String prefsFilePath)
            throws DataConversionException, IOException {
        return JsonUtil.readJsonFile(prefsFilePath, AccountsStorage.class);
    }

    public void saveAccountsPrefs(AccountsStorage accStorage) throws IOException {
        JsonUtil.saveJsonFile(accStorage, filePath);
    }

}
//@@author